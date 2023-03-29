package com.CentralElevatorManagement.Application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CentralElevatorManagement.Application.Entity.MaintenanceNotification;
import com.CentralElevatorManagement.Application.Service.copy.MaintenanceNotificationService;

/**
 * @author krishnakumar
 *
 */
@RestController
@RequestMapping("/ElevatorService/maintainance")
public class MaintenanceNotificationController {
	@Autowired
    private MaintenanceNotificationService maintenanceNotificationService;

    @PostMapping("/notify")
    public ResponseEntity<MaintenanceNotification> notifyMaintenance(@RequestBody MaintenanceNotification maintenanceNotification) {
        MaintenanceNotification notifyMaintenance = maintenanceNotificationService.notifyMaintenance(maintenanceNotification);  
        
        if(notifyMaintenance != null ) {
         return ResponseEntity.status(HttpStatus.OK).body(notifyMaintenance);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(notifyMaintenance);
        }
    }

    @GetMapping("/notify")
    public ResponseEntity<List<MaintenanceNotification>> getListNotifications(){
    	List<MaintenanceNotification> allNotifications = maintenanceNotificationService.getAllNotifications();
    	if(allNotifications.size() ==0 ) {
    		return null;
    	}
		return ResponseEntity.status(HttpStatus.OK).body(allNotifications);
    	
    }
    
}
