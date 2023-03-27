package com.document.workflow.Service.impl;

import com.document.workflow.Entity.Notification;
import com.document.workflow.Repository.NotificationRepository;
import com.document.workflow.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification createNotification(Notification notification) {
        notification.setCreatedAt(LocalDateTime.now());
        notification.setUpdatedAt(LocalDateTime.now());
        return notificationRepository.save(notification);
    }

    @Override
    public Notification updateNotification(Notification notification, Long id) {
        Notification oldNotification = notificationRepository.getReferenceById(id);
        oldNotification.setDesc(notification.getDesc());
        oldNotification.setRecipient(notification.getRecipient());
        oldNotification.setTitle(notification.getTitle());
        oldNotification.setUpdatedAt(LocalDateTime.now());
        return notificationRepository.save(oldNotification);
    }

    @Override
    public Notification getNotification(Long id) {
        return notificationRepository.findById(id).get();
    }

    @Override
    public List<Notification> getNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}