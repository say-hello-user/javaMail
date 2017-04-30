package mail.web.util;

import javax.mail.PasswordAuthentication;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
//ʵ��һ���û�ע��֮�����������Ӽ���Ĺ�����
//to��ʾҪ���͸��ĸ���
//code��ʾ������
public class MailUtils {
		public static void sendMail(String to,String code) throws AddressException, MessagingException
		{
			//�������Ӷ������ӵ����������
			Properties props = new Properties();
			Session session = Session.getDefaultInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication()
				{
					return new PasswordAuthentication("username", "password");
				}
			});
			//�����ʼ�����
			Message message = new MimeMessage(session);
			//���÷�����
			message.setFrom(new InternetAddress("username"));
			//�����ռ���
			message.setRecipient(RecipientType.TO, new InternetAddress(to));
			//�������������
			message.setSubject("����xx��վ�����ʼ�");
			//�������������
			message.setContent("<h1>����xx��վ ������������:<a  >","text/html;charset=utf-8");	
			//�����ʼ�
			Transport.send(message);
			
			}
}
