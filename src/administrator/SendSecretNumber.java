package administrator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.swing.*;

public class SendSecretNumber extends Authenticator {
	private String secretNumber = "", secretNumberVerify="";
	
	public PasswordAuthentication getPasswordAuthentication() {
		PasswordAuthentication pa = new PasswordAuthentication("humangasaur10@gmail.com", "64149686705162");
		return pa;
		
	}
	
	public String sendMail() {
		
		try {
		
			    
				Properties p = new Properties();
				p.put("mail.smtp.host","smtp.gmail.com");
				p.put("mail.smtp.port","587");
				p.put("mail.smtp.starttls.enable","true");
				p.put("mail.smtp.ssl.trust","smtp.gmail.com");
				p.put("mail.smtp.auth","true");
				p.put("mail.debug","true");
				
				SendSecretNumber mail = new SendSecretNumber();
				Session session = Session.getInstance(p, mail);
				MimeMessage message = new MimeMessage(session);
				message.setSubject("OTP for Login");
				
				Random random = new Random();
				for (int i = 0; i < 6; i++) {
					int number = random.nextInt(10);
					secretNumber = secretNumber + String.valueOf(number);
				}
				
				secretNumberVerify = secretNumber;
				secretNumber = "Your Secret number for Login is " + secretNumber;
				 
				InternetAddress address = new InternetAddress("vedantmishra104@gmail.com");	
				message.setRecipient(RecipientType.TO, address);
				message.setContent(secretNumber, "text/plain");
				Transport.send(message);
		
		} catch (Exception ex) {

			ex.printStackTrace();
		
		}
		return secretNumberVerify;	
	}



}
