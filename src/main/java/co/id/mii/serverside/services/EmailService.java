package co.id.mii.serverside.services;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import co.id.mii.serverside.models.dto.request.EmailRequest;

@Service
public class EmailService {
    private JavaMailSender mailSender;
    private TemplateEngine templateEngine; // panggil template emailnya

    @Autowired
    public EmailService(JavaMailSender mailSender, TemplateEngine templateEngine) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }

    // generate sebuah html
    public String generateMailHtml(String text1) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("mailtext", text1);

        final String templateFileName = "mail"; // Name of the template file without extension
        String output = this.templateEngine.process(templateFileName, new Context(Locale.getDefault(), variables));

        return output;
    }

    // method email simpel
    public EmailRequest sendSimpleEmail(EmailRequest emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRequest.getToEmail());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getBody());

        mailSender.send(message);
        System.out.println("Mail Send .......");
        return emailRequest;
    }

    // method email with file
    public EmailRequest sendEmailWithAttachment(EmailRequest emailRequest) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

            messageHelper.setTo(emailRequest.getToEmail());
            messageHelper.setSubject(emailRequest.getSubject());
            messageHelper.setText(generateMailHtml(emailRequest.getBody()), true);
            FileSystemResource fileSystemResource = new FileSystemResource(new File(emailRequest.getAttachment()));
            messageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);

            mailSender.send(mimeMessage);
            System.out.println("Send Mail With Attach");
        } catch (MessagingException e) {
            throw new IllegalStateException("Failed to send email");
        }
        return emailRequest;

    }

    // method email with template
    public EmailRequest sendEmailWithTemplate(EmailRequest emailRequest) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

            messageHelper.setTo(emailRequest.getToEmail());
            messageHelper.setSubject(emailRequest.getSubject());
            messageHelper.setText(generateMailHtml(emailRequest.getBody()), true);
            mailSender.send(mimeMessage);
            System.out.println("Send Mail With templ");
        } catch (MessagingException e) {
            throw new IllegalStateException("Failed to send email");
        }
        return emailRequest;

    }
}
