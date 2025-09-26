package com.tms.company_api.services;

import com.tms.company_api.models.Employee;
import org.springframework.stereotype.Service;

/**
 * The work of this service is to call notification api connector for different topics
 */
@Service
public class NotificationService {

    /**
     * Work of this function is send to invite employee notification
     * This function will call internally Notification api connector
     * @param employee
     */
    public void sendInviteEmployeeNotification(Employee employee){

    }

}
