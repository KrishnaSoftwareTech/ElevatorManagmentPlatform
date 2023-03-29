package com.CentralElevatorManagement.Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CentralElevatorManagement.Application.Entity.MaintenanceNotification;

/**
 * @author krishnakumar
 *
 */
public interface MaintenanceNotificationRepository  extends JpaRepository<MaintenanceNotification, Long>{

}
