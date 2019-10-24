package Examination;

import java.io.FileOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.net.httpserver.Authenticator;
import com.sun.net.httpserver.HttpExchange;

class Auth extends javax.mail.Authenticator {
	
	public PasswordAuthentication getPasswordAuthentication(){
		PasswordAuthentication pa = new PasswordAuthentication("humangasaur10@gmail.com","64149686705162");
		return pa;
	}
}

public class SendResult {

	public void sendResult(String[] userSelected, String[] correctOptions, double score,String email) throws Exception {
		
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("result");
		System.out.println("Before Creating Excel");

		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("Ques No.");
		cell = row.createCell(1);
		cell.setCellValue("Your Response");
		cell = row.createCell(2);
		cell.setCellValue("Correct Option");
		System.out.println("Before Loop");
		int i, j;
		for(i = 1; i <= userSelected.length; i++) {
			row = sheet.createRow(i);
			for(j = 0; j < 3; j++) {
				cell = row.createCell(j);
				if(j==0)
					cell.setCellValue("Q"+i);
				else if(j==1)
					cell.setCellValue(userSelected[i-1]);
				else cell.setCellValue(correctOptions[i-1]);
					
			}
			row = sheet.createRow(i+1);
			cell = row.createCell(1);
			cell.setCellValue("Your Scored");
			cell = row.createCell(2);
			cell.setCellValue("= "+score);

			
			
		}
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		System.out.println("Before Writing in Excel");
		FileOutputStream fo = new FileOutputStream("C:\\Users\\Vedant\\Desktop\\result.xlsx");
		wb.write(fo);
		wb.close();
		SendResult.send(email);
		
		
		
	}
	
	public static void send(String email) throws Exception {
		Properties p = System.getProperties();
		p.put("mail.smtp.host","smtp.gmail.com");
		p.put("mail.smtp.port","587");
		p.put("mail.smtp.starttls.enable","true");
//		p.put("mail.smtp.ssl.trust","smtp.gmail.com");
		p.put("mail.smtp.auth","true");
		p.put("mail.debug","true");
		
		Auth auth = new Auth();
		Session session = Session.getInstance(p,auth);
		String userEmail = email;
		MimeMessage message = new MimeMessage(session);
		InternetAddress address = new InternetAddress(userEmail);
		message.setRecipient(RecipientType.TO, address);
		message.setSubject("Result");
		
		BodyPart bPart1 = new MimeBodyPart();
		bPart1.setText("Your result is Attatched below.");
		
		MimeBodyPart mbp2 = new MimeBodyPart();
		
		String filename = "C:\\Users\\Vedant\\Desktop\\result.xlsx";
		DataSource source = new FileDataSource(filename);
		mbp2.setDataHandler(new DataHandler(source));
		mbp2.setFileName(filename);
		
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(bPart1);
		multipart.addBodyPart(mbp2);
		
		message.setContent(multipart);
		Transport.send(message);
		System.out.println("Message sent");
	}
	
	public static void main(String[] args) throws Exception {
		SendResult sd = new SendResult();
		String[] us = {"d","a","c","b","a","a","c","a","d","d"};
		String[] co = {"d","b","c","b","d","d","a","a","b","c"};
		sd.sendResult(us,co, 9.0, "itsv3d4nt@gmail.com");
	}
	
}

		

