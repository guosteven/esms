package cn.guoxy.esms.commons.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * �ʼ����͹�����
 * 
 * @author gxy
 *
 */
public class SendEmail {
	/**
	 * �����ʼ�����
	 * 
	 * @param session
	 *            �ʼ���session
	 * @param msg
	 *            ��Ϣ
	 * @param email
	 *            ���͵ĵ�ַ
	 * @return �ʼ�����
	 * @throws Exception
	 */
	public static MimeMessage createSimpleMail(Session session, String msg, String email) throws Exception {
		// �����ʼ�����
		MimeMessage message = new MimeMessage(session);
		// ָ���ʼ��ķ�����
		message.setFrom(new InternetAddress("18435114377m@sina.cn"));
		// ָ���ʼ����ռ��ˣ����ڷ����˺��ռ�����һ���ģ��Ǿ����Լ����Լ���
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
		// �ʼ��ı���
		message.setSubject("������֤");
		// �ʼ����ı�����
		message.setContent(msg, "text/html;charset=UTF-8");
		// ���ش����õ��ʼ�����
		return message;
	}

	/**
	 * �����ʼ�
	 * 
	 * @param email
	 *            �����ַ
	 * @param msg
	 *            ��Ϣ
	 * @throws Exception
	 */
	public static void sendEail(String email, String msg) throws Exception {
		Properties prop = new Properties();
		prop.setProperty("mail.host", "smtp.sina.cn");
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.smtp.auth", "true");
		// ʹ��JavaMail�����ʼ���5������
		// 1������session
		Session session = Session.getInstance(prop);
		// ����Session��debugģʽ�������Ϳ��Բ鿴��������Email������״̬
		session.setDebug(true);
		// 2��ͨ��session�õ�transport����
		Transport ts = session.getTransport();
		// 3��ʹ��������û��������������ʼ��������������ʼ�ʱ����������Ҫ�ύ������û����������smtp���������û��������붼ͨ����֤֮����ܹ����������ʼ����ռ��ˡ�
		ts.connect("smtp.sina.cn", "18435114377m@sina.cn", "lin960320");
		// 4�������ʼ�
		Message message = createSimpleMail(session, msg, email);
		// 5�������ʼ�
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}
}