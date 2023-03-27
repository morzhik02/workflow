package com.document.workflow.Controller;

import com.document.workflow.Entity.Notification;
import com.document.workflow.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public Notification createNotification(@RequestBody Notification notification){
        return notificationService.createNotification(notification);
    }

    @PutMapping("/{id}")
    public Notification updateNotification(@RequestBody Notification notification, @PathVariable("id") Long id){
        return notificationService.updateNotification(notification, id);
    }

    @GetMapping(value = "/{id}")
    public Notification getNotification(@PathVariable("id") Long id){
        return notificationService.getNotification(id);
    }

    @GetMapping
    public List<Notification> listAllNotifications(){
        List<Notification> notifications = notificationService.getNotifications();
        return notifications;
    }

    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable("id") Long id){
        notificationService.deleteNotification(id);
    }

}
