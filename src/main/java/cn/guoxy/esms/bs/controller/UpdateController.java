package cn.guoxy.esms.bs.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.guoxy.esms.bs.entity.Admin;
import cn.guoxy.esms.bs.entity.SmallType;
import cn.guoxy.esms.bs.entity.UpdateReturnType;
import cn.guoxy.esms.bs.service.UpdateService;
import cn.guoxy.esms.commons.entity.Goods;
import cn.guoxy.esms.commons.resources.EsmsResource;
import cn.guoxy.esms.commons.util.ImageUtil;
import cn.guoxy.esms.commons.util.LogFactory;

/**
 * �ϴ���Ʒ�������
 * 
 * @author gxy
 *
 */
@Controller
@RequestMapping("/bs/")
public class UpdateController {
	@Resource(name = "updateService")
	private UpdateService updateService;
	/**
	 * ��־
	 */
	private static Logger log = LogFactory.getGlobalLog();

	/**
	 * �ϴ�ҳ��
	 * <p>
	 * �����ϴ�ҳ��ʱ����session�а�һ��token����token��Ϊ�˷�ֹ�����ظ��ύ
	 * ��ҳ�������token����õ������������У����ύʱһͬ�ύ
	 * 
	 * @return ��ͼ��
	 */
	@RequestMapping("/toUpdate.do")
	public String toUpdate(HttpSession session) {
		String token = Long.toString(System.currentTimeMillis());
		session.setAttribute("token", token);
		return "bs/update";
	}

	/**
	 * ͼƬ�ϴ� ����ֵ��һ���Զ�������
	 * 
	 * @param request
	 *            �������
	 * @param file
	 *            �ļ�
	 * @return �Զ����ϴ���������
	 */
	@RequestMapping("/update.do")
	@ResponseBody
	public UpdateReturnType update(MultipartFile file) {
		String realPath = EsmsResource.map.get("imgPath");
		String originalFilename = null;
		UpdateReturnType updateReturnType = new UpdateReturnType();
		if (file.isEmpty()) {
			updateReturnType.setCode(1);
			return updateReturnType;
		} else {
			originalFilename = file.getOriginalFilename();
			String newFileName = UUID.randomUUID().toString().replace("-", "")
					+ originalFilename.substring(originalFilename.lastIndexOf("."));
			String newFileNamebig = UUID.randomUUID().toString().replace("-", "")
					+ originalFilename.substring(originalFilename.lastIndexOf("."));
			String filePathbig = realPath;
			try {
				ImageUtil.resize(file.getInputStream(), filePathbig, newFileNamebig);
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath, newFileName));
				updateReturnType.setCode(0);
				updateReturnType.setSmallImg(newFileName);
				updateReturnType.setBigImg(newFileNamebig);
			} catch (IOException e) {
				updateReturnType.setCode(2);
				e.printStackTrace();
				return updateReturnType;
			}
		}
		return updateReturnType;

	}

	/**
	 * ����ѡ��ò���
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getType.do")
	@ResponseBody
	public List<SmallType> getType(HttpServletRequest request) {
		int btId = Integer.parseInt(request.getParameter("btId"));
		List<SmallType> list = updateService.getSmallType(btId);
		return list;

	}

	/**
	 * ���ύ���ύʱ���жϱ��Ƿ��ظ��ύ,���ظ��ύ��ִ�б��淽��
	 * 
	 * @param request
	 *            �������
	 * @param response
	 *            ��Ӧ����
	 * @throws IOException
	 *             io�쳣
	 */

	@RequestMapping("/formupdate.do")
	public void formupdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (updateService.isRepeatSubmit(request)) {
			return;
		}
		request.getSession().removeAttribute("token");// �Ƴ�session�е�token
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Goods goods = new Goods();
		goods.setGoodsName(request.getParameter("goodsName"));
		goods.setGoodsShow(request.getParameter("goodsShow"));
		goods.setBtId(Integer.parseInt(request.getParameter("bigType")));
		goods.setStId(Integer.parseInt(request.getParameter("smallType")));
		goods.setSeason(Integer.parseInt(request.getParameter("season")));
		goods.setGoodsPrice(Integer.parseInt(request.getParameter("goodsPrice")));
		goods.setGoodsCount(Integer.parseInt(request.getParameter("goodsCount")));
		goods.setBigImg(request.getParameter("bigImg"));
		goods.setSmallImg(request.getParameter("smallImg"));
		goods.setUpdateTime(new java.sql.Date(System.currentTimeMillis()));
		ImageUtil.addShow(goods);
		updateService.saveGoods(goods);
		log.info("UPDATE GOODS--->" + ((Admin) request.getSession().getAttribute("admin")).getAdminName());
		out.println("��Ʒ�ϴ��ɹ�");
	}

}
