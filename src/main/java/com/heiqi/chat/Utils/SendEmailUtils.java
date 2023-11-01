package com.heiqi.chat.Utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
public final class SendEmailUtils {
    private static final String User = "crucio@crucio.cn";
    private static final String PASSWORD = "2JB3Z7hV4F7cKpdF";


    public static void sendEmail(String email, String code) throws Exception {
        System.out.println("-----------------进入发送邮箱--------------");
        final Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "smtp.exmail.qq.com");
        properties.put("mail.smtp.port", "587");


        //发件人的账号
        properties.put("mail.user", User);
        properties.put("mail.password", PASSWORD);

        //构建授权信息,用于进行smtp的身份认证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //用户名 密码
                String userName = properties.getProperty("mail.user");
                String passWord = properties.getProperty("mail.password");
                return new PasswordAuthentication(userName, passWord);
            }
        };

        //使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(properties, authenticator);
        // 创建邮件信息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        String username = properties.getProperty("mail.user");
        InternetAddress form = new InternetAddress(username);
        message.setFrom(form);
        // 设置收件人
        InternetAddress toAddress = new InternetAddress(email);
        message.setRecipient(Message.RecipientType.TO, toAddress);
        // 设置邮件标题
        message.setSubject("来自Crucio的验证信息");
        // 设置邮件的具体内容
        message.setContent("尊敬的:" + email + "您的验证码为:  " + code + "  ;有效期为5分钟，请勿泄露他人", "text/html;charset=UTF-8");
        Transport.send(message);
        System.out.println("-----------------进入发送邮箱结束--------------");


    }

    public static void sendMatchEmail(String email) throws Exception {
        final Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "smtp.exmail.qq.com");
        properties.put("mail.smtp.port", "587");


        //发件人的账号
        properties.put("mail.user", User);
        properties.put("mail.password", PASSWORD);

        //构建授权信息,用于进行smtp的身份认证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //用户名 密码
                String userName = properties.getProperty("mail.user");
                String passWord = properties.getProperty("mail.password");
                return new PasswordAuthentication(userName, passWord);
            }
        };

        //使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(properties, authenticator);
        // 创建邮件信息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        String username = properties.getProperty("mail.user");
        InternetAddress form = new InternetAddress(username);
        message.setFrom(form);
        // 设置收件人
        InternetAddress toAddress = new InternetAddress(email);
        message.setRecipient(Message.RecipientType.TO, toAddress);
        // 设置邮件标题
        message.setSubject("Crucio通知");
        // 设置邮件的具体内容
        message.setContent("您好，Crucio已成功为您找到一位适配对象，请前往Crucio查看", "text/html;charset=UTF-8");
        Transport.send(message);


    }

//    public static void main(String[] args) {
//        try {
//            SendEmailUtils.sendEmail("15355315088@163.com","1234");
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//
//
//    }
}
