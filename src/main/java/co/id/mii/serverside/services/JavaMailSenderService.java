package co.id.mii.serverside.services;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import co.id.mii.serverside.models.dto.request.EmailRequest;

@Component
public class JavaMailSenderService {
    private JavaMailSender mailSender;

    @Autowired
    public JavaMailSenderService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public EmailRequest sendSimpleEmail(EmailRequest emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRequest.getToEmail());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getBody());

        mailSender.send(message);
        System.out.println("Mail Send .......");
        return emailRequest;
    }

    public EmailRequest sendEmailWithAttachment(EmailRequest emailRequest) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

            messageHelper.setTo(emailRequest.getToEmail());
            messageHelper.setSubject(emailRequest.getSubject());
            messageHelper.setText(emailRequest.getBody());

            FileSystemResource fileSystemResource = new FileSystemResource(new File(emailRequest.getAttachment()));
            messageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);

            mailSender.send(mimeMessage);
            System.out.println("Send Mail With Attach");
        } catch (MessagingException e) {
            throw new IllegalStateException("Failed to send email");
        }
        return emailRequest;

    }
}
