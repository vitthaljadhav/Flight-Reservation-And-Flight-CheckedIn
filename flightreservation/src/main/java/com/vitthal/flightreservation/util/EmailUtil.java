package com.vitthal.flightreservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	@Value("${com.vithhal.flightreservation.itinerary.email.body}")
	private  String EMAIL_BODY;

	//private  String EMAIL_BODY = "please find your Itinerary attached.";

	@Value("${com.vithhal.flightreservation.itinerary.email.subject}")
	private  String EMAIL_SUBJECT;
	
	//private  String EMAIL_SUBJECT = "Itinerary for your Flight";
	
	
	private static final Logger LOGGER=LoggerFactory.getLogger(EmailUtil.class);
	@Autowired
	private JavaMailSender sender;

	public void sendItinerary(String toAddress, String filePath) {
		LOGGER.info("inside sendItinerary()");
		MimeMessage message = sender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true); // new MimeMessageHelper(message,true)
																				// !true means some attachment false no
																				// attachment .it is by default is false
			helper.setTo(toAddress);
			helper.setSubject(EMAIL_SUBJECT);
			helper.setText(EMAIL_BODY);
			helper.addAttachment("Itinerary", new File(filePath));
			sender.send(message);
		} catch (MessagingException e) {
			//e.printStackTrace();
			LOGGER.error("Exception inside sendItinerary() "+e);
		}
	}
}
