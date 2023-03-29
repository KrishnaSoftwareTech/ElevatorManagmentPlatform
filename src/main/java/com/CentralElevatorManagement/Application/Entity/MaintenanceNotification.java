package com.CentralElevatorManagement.Application.Entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author krishnakumar
 *
 */
@Entity
@Table(name = "maintenance_notifications")
public class MaintenanceNotification {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "elevator_id")
    private Long elevatorId;
    
    @Column(name = "hotel_id")
    private Long hotelId;
    
    @Column(name = "notification_time")
    private LocalDateTime notificationTime;
    
    @Column(name = "notification_message")
    private String notificationMessage;
    
    @Column(name = "resolved")
    private Boolean resolved;

    
	/**
	 * @param id
	 * @param elevatorId
	 * @param hotelId
	 * @param notificationTime
	 * @param notificationMessage
	 * @param resolved
	 */
	public MaintenanceNotification(Long id, Long elevatorId, Long hotelId, LocalDateTime notificationTime,
			String notificationMessage, Boolean resolved) {
		super();
		this.id = id;
		this.elevatorId = elevatorId;
		this.hotelId = hotelId;
		this.notificationTime = notificationTime;
		this.notificationMessage = notificationMessage;
		this.resolved = resolved;
	}
public MaintenanceNotification() {
	super();
}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getElevatorId() {
		return elevatorId;
	}

	public void setElevatorId(Long elevatorId) {
		this.elevatorId = elevatorId;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public LocalDateTime getNotificationTime() {
		return notificationTime;
	}

	public void setNotificationTime(LocalDateTime notificationTime) {
		this.notificationTime = notificationTime;
	}

	public String getNotificationMessage() {
		return notificationMessage;
	}

	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}
	public Boolean getResolved() {
		return resolved;
	}
	public void setResolved(Boolean resolved) {
		this.resolved = resolved;
	}
    
}