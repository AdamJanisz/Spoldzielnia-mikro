package com.example.email.service;

public interface EmailSender {
    void sendEmail(String to, String subject, String content);
}
