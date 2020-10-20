package com.itstudent.service_impl;

import com.itstudent.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String emailSender;

    @Override
    public boolean sendMail(String userMail, String header, String content) {
        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(userMail);
            mail.setFrom(emailSender);
            mail.setSubject(header);
            mail.setText(content);
            javaMailSender.send(mail);
            return true;
        } catch (MailException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean sendHtmlMail(String userMail, String header, String content) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mail = new MimeMessageHelper(mimeMessage, "utf-8");
            mail.setTo(userMail);
            mail.setFrom(emailSender);
            mail.setSubject(header);
            mail.setText(content, true);
            //String[] cc = {"aa@mail.com","hieu2@gmail.com"};
            //mail.setCc(cc);
            // mail.addAttachment("ảnh",new File("D:\\image\\a.jpg"));
            javaMailSender.send(mimeMessage);
            return true;
        } catch (MailException | MessagingException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
