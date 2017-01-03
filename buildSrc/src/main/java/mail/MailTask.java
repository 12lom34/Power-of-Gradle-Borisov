package mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.Email;

import org.gradle.api.*;
import org.gradle.api.logging.*;
import org.gradle.api.tasks.*;

public class MailTask extends DefaultTask {
	private String to;

	@Input
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
	
	@TaskAction
	public void sendMail() throws Exception {
		getLogger().lifecycle("Sending mail ... " + to);
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setAuthenticator(new DefaultAuthenticator("12.lom.34", (String) (getProject().getProperties().get("pwd"))));
		email.setSmtpPort(465);
		email.setSSLOnConnect(true);
		email.setFrom("12.lom.34@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("Babushka, menya k uziny ne budet. Build is down.");
		email.addTo(to);
		email.send();
		System.out.println("Mail sent.");
	}
}

