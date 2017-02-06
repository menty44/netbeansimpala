package email;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Email {
	
	public static void main (String[]args) throws AddressException, MessagingException{
		
		System.out.println("Sending mail...");
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.secureserver.net");
        props.setProperty("mail.user", "menty44@gmail.com");
        props.setProperty("mail.password", "XZB9O6G8fred.");

        Session mailSession = Session.getDefaultInstance(props, null);
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();
        
        System.out.println(transport);

        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject("Final Draft");
        message.setFrom(new InternetAddress("menty44@gmail.com"));
        message.addRecipient(Message.RecipientType.TO,
             //new InternetAddress("gill.oburu@impalapay.com" ));
        new InternetAddress("fred.oluoch@impalapay.com" ));

        //
        // This HTML mail have to 2 part, the BODY and the embedded image
        //
        MimeMultipart multipart = new MimeMultipart("related");

        // first part  (the html)
        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText ="<!DOCTYPE html>"+
        "<html lang=\"en\">"+ 
        "<head>"+ 
        "<meta charset=\"utf-8\">" + 
        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"+
        "<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">"+
        "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>"+
        "<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>"+
        "</head>"+
        "<body>" +
        
        "<div class=\"container-fluid\">" +
        "<div class=\"row\">" +
        "<div class=\"col-sm-4\">" +
        //"<h3>Column 1</h3>" +
        "<p>" +
        "<h2>"+ "Dear Partner," + "</h2>"+ 
        "<h4>"+ "<centre>"+"Introduction to Impala Pay" + "</centre>"+"</h4>"+
        "<h2>"+ "" + "</h2>"+
        "<h4>"+ "<font color=\"red\">" + "Fueling border free payments" + "</h4>"+
        "<h2>"+ " " + "</h2>"+
        "<h2>"+ " " + "</h2>"+
        "<h2>"+ " " + "</h2>"+
        "<h2>"+ " " + "</h2>"+
        "<h2>"+ " " + "</h2>"+
        "<h2>"+ " " + "</h2>"+
        "<h2>"+ " " + "</h2>"+
        "<h2>"+ " " + "</h2>"+
        "<h2>"+ " " + "</h2>"+
        "<h2>"+ " " + "</h2>"+
        "<h2>"+ " " + "</h2>"+
//        "<img src=\"http://blaqueyard.com/impala/1.png\" width=\"1000\" height=\"800\" >" +
//        "<img src=\"http://blaqueyard.com/impala/2.png\" width=\"1000\" height=\"800\"  >" + 
//        "<img src=\"http://blaqueyard.com/impala/3.png\" width=\"1000\" height=\"800\"  >" +
//        "<img src=\"http://blaqueyard.com/impala/4.png\" width=\"1000\" height=\"800\"  >" +
        //"<img src=\"http://blaqueyard.com/impala/5.jpg\" class=\"img-responsive\"  >" +
        "</p>" +
        "</div>" +
        
        " <div class=\"col-sm-4\">" +
        //"<h3>Column 2</h3>" +
        "<p>" +
        //"<img src=\"http://blaqueyard.com/impala/1.jpg\" class=\"img-responsive\">" +
        "</p>" +
        "</div>" +
        "" +
        "" +
        "</div>" +
        "</div>" +
        "" +
        "</body>" +
        "</html>" +
        
//        "<H1>Hello,</H1> <img src=\"http://blaqueyard.com/impala/1.jpg\">" + 
//        "<img src=\"http://blaqueyard.com/impala/2.jpg\">" +
//        "<img src=\"http://blaqueyard.com/impala/3.jpg\">" +
//        "<img src=\"http://blaqueyard.com/impala/4.jpg\">" +
        "";
        messageBodyPart.setContent(htmlText, "text/html");

        // add it
        multipart.addBodyPart(messageBodyPart);
        
        // second part (the image)
//        messageBodyPart = new MimeBodyPart();
//        DataSource fds1 = new FileDataSource
//          ("1.jpg");
//        DataSource fds2 = new FileDataSource
//                ("2.jpg");
//        DataSource fds3 = new FileDataSource
//                ("3.jpg");
//        DataSource fds4 = new FileDataSource
//                ("4.jpg");
        
        
        //messageBodyPart.setDataHandler(new DataHandler(fds1));
        messageBodyPart.setHeader("Content-ID","<image>");

        // add it
        multipart.addBodyPart(messageBodyPart);

        // put everything together
        message.setContent(multipart);

        transport.connect();
        transport.sendMessage(message,
            message.getRecipients(Message.RecipientType.TO));
        transport.close();
        }
	

}
