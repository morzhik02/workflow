package com.document.workflow.Service;

import com.document.workflow.Entity.Notification;

import java.util.List;


public interface NotificationService {
    Notification createNotification(Notification notification);
    Notification updateNotification(Notification notification, Long id);
    Notification getNotification(Long id);
    List<Notification> getNotifications();
    void deleteNotification(Long id);
}
