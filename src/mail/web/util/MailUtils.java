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
//实现一个用户注册之后点击邮箱链接激活的工具类
//to表示要发送给哪个人
//code表示激活码
public class MailUtils {
		public static void sendMail(String to,String code) throws AddressException, MessagingException
		{
			//创建连接对象，连接到邮箱服务器
			Properties props = new Properties();
			Session session = Session.getDefaultInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication()
				{
					return new PasswordAuthentication("username", "password");
				}
			});
			//创建邮件对象
			Message message = new MimeMessage(session);
			//设置发件人
			message.setFrom(new InternetAddress("username"));
			//设置收件人
			message.setRecipient(RecipientType.TO, new InternetAddress(to));
			//设置邮箱的主题
			message.setSubject("来自xx网站激活邮件");
			//设置邮箱的内容
			message.setContent("<h1>来自xx网站 请点击以下链接:<a  >","text/html;charset=utf-8");	
			//发送邮件
			Transport.send(message);
			
			}
}
