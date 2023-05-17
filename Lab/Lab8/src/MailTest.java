import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;
import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.*;


public class MailTest
{
   public static void main(String[] args) throws MessagingException, IOException
   {
      // read properties
      Properties props = new Properties();
      try (InputStream in = Files.newInputStream(Paths.get("F:\\CS209\\Lab\\Lab8\\src\\mail.properties")))
      {
         props.load(in);
      }

      // read message info
      List<String> lines = Files.readAllLines(Paths.get("F:\\CS209\\Lab\\Lab8\\src\\message.txt"), StandardCharsets.UTF_8);

      String from = lines.get(0);
      String to = lines.get(1);
      String subject = lines.get(2);

      StringBuilder builder = new StringBuilder();
      for (int i = 3; i < lines.size(); i++)
      {
         builder.append(lines.get(i));
         builder.append("\n");
      }


      // read password for your email account
      System.out.println("Password: ");
      Scanner scanner = new Scanner(System.in);
      String password = scanner.next();


      Session mailSession = Session.getDefaultInstance(props);
      MimeMessage message = new MimeMessage(mailSession);
      // TODO 1: check the MimeMessage API to figure out how to set the sender, receiver, subject, and email body
      // TODO 2: check the Session API to figure out how to connect to the mail server and send the message
      message.setFrom(new InternetAddress(from));
      message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
      message.setSubject(subject);
      message.setSentDate(new Date());
      message.setText(builder.toString());
      Transport transport = mailSession.getTransport();
      transport.connect(null, password);
      transport.sendMessage(message, message.getAllRecipients());
      transport.close();
   }
}