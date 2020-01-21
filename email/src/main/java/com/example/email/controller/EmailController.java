package com.example.email.controller;

import com.example.email.service.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Controller
@RequestMapping("/email")
public class EmailController {
    private final EmailSender emailSender;
    private final TemplateEngine templateEngine;


    @Autowired
    public EmailController(EmailSender emailSender,
                           TemplateEngine templateEngine) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }

    @PostMapping("/{emailAddress}")
    public void send(@PathVariable String emailAddress) {
        Context context = new Context();
        context.setVariable("header", "FAKTURA");
        context.setVariable("title", " Nowy rachunek dostępny na platformie twojej Społdzielni Mieszkaniowej");
        context.setVariable("description", "Kliknij aby zapłacić");
        String body = templateEngine.process("message", context);
        emailSender.sendEmail(emailAddress, "Nowa FAKTURA", body);
    }

}
