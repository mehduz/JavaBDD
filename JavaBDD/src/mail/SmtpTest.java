package mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class SmtpTest {

	public void envoyerMail(String recipient) throws Exception {

		String username = "universitymanagerefrei@gmail.com";
		String password = "motdepasse!";
		//String recipient = "romaincourtieux@hotmail.com";

		Properties props = new Properties();

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.from", username);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "587");
		props.setProperty("mail.debug", "true");

		Session session = Session.getInstance(props, null);
		MimeMessage msg = new MimeMessage(session);
		
		msg.setRecipients(Message.RecipientType.TO, recipient);
		msg.setSubject("Important : Convocation EFREI");
		msg.setSentDate(new Date());
		msg.setText("Bonjour, vous avez été convoqué par un de vos professeur, merci d'appeler le secretariat pour prendre note du rendez-vous.\n"
				+ "Mail autogenere par l'application University Manager\n");

		Transport transport = session.getTransport("smtp");

		transport.connect(username, password);
		transport.sendMessage(msg, msg.getAllRecipients());
		transport.close();

	}
	
}