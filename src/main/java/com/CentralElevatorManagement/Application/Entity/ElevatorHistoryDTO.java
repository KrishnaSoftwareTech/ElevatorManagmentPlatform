package com.CentralElevatorManagement.Application.Entity;

/**
 * @author krishnakumar
 *
 */
import java.time.LocalDateTime;

public class ElevatorHistoryDTO {
    private Long elevatorId;
    private Long hotelId;
    private String hotelName;
    private Integer floor;
    private LocalDateTime timestamp;
	/**
	 * @param elevatorId
	 * @param hotelId
	 * @param hotelName
	 * @param floor
	 * @param timestamp
	 */
	public ElevatorHistoryDTO(Long elevatorId, Long hotelId, String hotelName, Integer floor, LocalDateTime timestamp) {
		super();
		this.elevatorId = elevatorId;
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.floor = floor;
		this.timestamp = timestamp;
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
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}


}