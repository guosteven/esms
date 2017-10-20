package cn.guoxy.esms.commons.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import cn.guoxy.esms.fs.entity.User;

/**
 * ���������ɹ�����
 * 
 * @author gxy
 *
 */
public class OrderNumber {
	/**
	 * ���ɶ����ţ���ʽ�ǣ�yyyyMMddHHmmss + 8λ�û�Id + 2λ�����
	 * 
	 * @param session
	 * @return
	 */
	public static String CreateOrderNumber(HttpSession session) {
		String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		User user = (User) session.getAttribute("user");
		String id = String.format("%8d", user.getId()).replace(" ", "0");
		Random ran = new Random();
		String r = String.format("%2d", ran.nextInt(100)).replace(" ", "0");
		String orderNumber = date + id + r;
		return orderNumber;
	}
}
