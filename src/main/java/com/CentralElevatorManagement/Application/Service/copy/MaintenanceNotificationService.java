package com.CentralElevatorManagement.Application.Service.copy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CentralElevatorManagement.Application.Entity.MaintenanceNotification;
import com.CentralElevatorManagement.Application.Repository.MaintenanceNotificationRepository;

/**
 * @author krishnakumar
 *
 */
@Service
public class MaintenanceNotificationService {
	
	@Autowired
	private MaintenanceNotificationRepository notificationRepo;

	private MaintenanceNotification notify=new MaintenanceNotification();

	public MaintenanceNotification notifyMaintenance(MaintenanceNotification maintenanceNotification) {
		maintenanceNotification.setNotificationTime(LocalDateTime.now());
		if(maintenanceNotification.getResolved() == null) {
			maintenanceNotification.setResolved(false);
			notify.setResolved(false);
		}
		try {
			notify.setElevatorId(maintenanceNotification.getElevatorId());
			notify.setHotelId(maintenanceNotification.getHotelId());
			notify.setNotificationMessage(maintenanceNotification.getNotificationMessage());
			if(maintenanceNotification.getResolved() == null) {
				notify.setResolved(false);
			}
			if(maintenanceNotification.getId() == null) {
				Random random = new Random(); 
				notify.setId(random.nextLong());
			}
			if(maintenanceNotification.getNotificationTime() == null) {
				notify.setNotificationTime(LocalDateTime.now());
			}else {
			notify.setNotificationTime(maintenanceNotification.getNotificationTime());}
		    notificationRepo.save(maintenanceNotification);
		}catch (Exception e) {
			throw new 	InternalError("Unable to Notify");
		}
		return notify;
	}

	public List<MaintenanceNotification> getAllNotifications() {
		List<MaintenanceNotification> list;
		try {
		 list = notificationRepo.findAll();
		}catch (Exception e) {
			throw new InternalError("Failed to get Notifiacations");
		}
		return list;
	}

}
