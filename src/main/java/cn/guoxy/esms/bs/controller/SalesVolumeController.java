package cn.guoxy.esms.bs.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.guoxy.esms.bs.service.SalesVolumeService;

/**
 * �����������
 * 
 * @author gxy
 *
 */
@Controller
@RequestMapping("/bs/")
public class SalesVolumeController {
	@Resource(name = "salesVolumeService")
	private SalesVolumeService salesVolumeService;

	/**
	 * ת����ͼ��ҳ��
	 * 
	 * ������
	 * 
	 * @return ��ͼ��
	 */
	@RequestMapping("tochart.do")
	public String tochart() {
		return "bs/chart";
	}

	/**
	 * ���������Ϣ
	 * 
	 * @return ������Ϣ
	 */
	@RequestMapping("getValue.do")
	@ResponseBody
	public Map<String, Integer> getValue() {
		Map<String, Integer> map = salesVolumeService.getSalesVolume();
		return map;
	}
}
