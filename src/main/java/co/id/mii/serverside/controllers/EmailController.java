package co.id.mii.serverside.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.id.mii.serverside.models.dto.request.EmailRequest;
import co.id.mii.serverside.services.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
    private EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    // post email simple
    @PostMapping
    public ResponseEntity<EmailRequest> sendSimpleEmail(@RequestBody EmailRequest emailRequest) {
        return new ResponseEntity(emailService.sendSimpleEmail(emailRequest), HttpStatus.CREATED);
    }

    // post email with file
    @PostMapping("/attachment")
    public ResponseEntity<EmailRequest> sendEmailWithAttachment(@RequestBody EmailRequest emailRequest) {
        return new ResponseEntity(emailService.sendEmailWithAttachment(emailRequest), HttpStatus.CREATED);
    }

    // post email with template
    @PostMapping("/template")
    public ResponseEntity<EmailRequest> sendEmailWithTemplate(@RequestBody EmailRequest emailRequest) {
        return new ResponseEntity(emailService.sendEmailWithTemplate(emailRequest), HttpStatus.CREATED);
    }

    // @PostMapping
    // public EmailRequest sendSimpleEmail(@RequestBody EmailRequest emailRequest) {
    // return mailSenderService.sendSimpleEmail(emailRequest);
    // }

    // @PostMapping("/attach")
    // public EmailRequest sendEmailWithAttachment(@RequestBody EmailRequest
    // emailRequest) {
    // return mailSenderService.sendEmailWithAttachment(emailRequest);
    // }
}
