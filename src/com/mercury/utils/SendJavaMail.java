package com.mercury.utils;
// http://www.oracle.com/technetwork/java/javamail/faq-135477.html
import java.awt.Color;
import java.util.Properties;
import java.util.Date;
import javax.mail.*;                  // Include Authenticator, Message, PasswordAuthentication, Session, Transport
import javax.mail.internet.*;     // Include InternetAddress, MimeMessage

public class SendJavaMail {
	
	//private static final String signature="Jih-Hua Fan\n Master Student,\n School of Electrical and Computer Engineering \nPurdue University  \n1-765-637-8113";
	
	public static void setWelcomeMail(String username, String email) {
		
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";  
        Properties prop = System.getProperties();
        prop.setProperty("mail.smtp.host", "smtp.gmail.com");   
        prop.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);   
        prop.setProperty("mail.smtp.socketFactory.fallback", "false");   
        prop.setProperty("mail.smtp.port", "465");   
        prop.setProperty("mail.smtp.socketFactory.port", "465");   
        prop.put("mail.smtp.auth", "true");   
        final String user = "jhfan.eo97g";
        final String password = "Merry5210";
        
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() { 
		return new PasswordAuthentication(user, password); } 
            });
        
        try {
        	
        	// a new email setting
        	Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("jhfan.eo97g@gmail.com"));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            msg.setSubject("Welcome Mail From RTS teams"); msg.setSentDate(new Date()); 
            
            // main part
            Multipart multipart = new MimeMultipart();
            
            // add content to body
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            String content="Hi, "+ username + "<br>"+"&nbsp;&nbsp;&nbsp;Thank you for registraion RTS account. Thank you very much."+"<br><br>"+ "Best Regards"+"<br>";
            String signature="RTS team"+"<br>";
            String allContents=content+"<br>"+addColor(signature, Color.BLUE);
            messageBodyPart.setContent(allContents, "text/html");
            multipart.addBodyPart(messageBodyPart);// add to main part
            
            // add attachment
            //MimeBodyPart messagePart = new MimeBodyPart();
            //messagePart.attachFile("C:\\Users\\jhfan\\Downloads\\status_20141017.doc");
        	//multipart.addBodyPart(messagePart);//add to main part
            
        	// add all parts and then send out
        	msg.setContent(multipart);
            Transport.send(msg);
            System.out.println("Message sent successfully!");
        } catch (Exception e) { System.out.println(e); }
    }

	private static String addColor(String msg, Color color) {
	    String hexColor = String.format("#%06X",  (0xFFFFFF & color.getRGB()));
	    String colorMsg = "<FONT COLOR=\"#" + hexColor + "\">" + msg + "</FONT>";
	    return colorMsg;
	}
}
