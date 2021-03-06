package com.example.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

@Service
public class EmailSenderImpl implements EmailSender{
    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public void sendEmail(String to, String title, String content) {
        MimeMessage mail = javaMailSender.createMimeMessage();
        try {

            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setReplyTo("newsletter@codecouple.pl");
            helper.setFrom("newsletter@codecouple.pl");
            helper.setSubject(title);
            helper.setText(content, true);
            //helper.addAttachment("my.pdf",new ByteArrayResource());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mail);
    }
}
