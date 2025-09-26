package com.tms.notification_api.notification_api.service;

import com.tms.notification_api.notification_api.models.Employee;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmployeeService {
    JavaMailSender javaMailSender;
    TemplateEngine templateEngine;
    @Autowired
    public EmployeeService(JavaMailSender javaMailSender,
                           TemplateEngine templateEngine){

                this.javaMailSender=javaMailSender;
                this.templateEngine=templateEngine;
    }
    public void inviteEmployee(Employee employee,String acceptUrl,String declineUrl,){
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage,true,"utf-8");hashCode()

        Context context=new Context();
        context.setVariable("employee",employee);
        context.setVariable("companyName",employee.getCompany());
        context.setVariable("roleName",employee.getRole().getRoleName());
        context.setVariable("employeeEmail",employee.getEmployeeEmail());
        context.setVariable("acceptUrl",);



    }
}
