package com.CentralElevatorManagement.Application.Entity;

/**
 * @author krishnakumar
 *
 */
public class HotelDTO {
   private Long HotelID;
   private String HotelName;
   private String Location;
   private Long ElevatorID;
   private ElevatorStatus Status;
	public HotelDTO(Long hotelID, String hotelName, String location, Long elevatorIDl, ElevatorStatus status) {
		super();
		HotelID = hotelID;
		HotelName = hotelName;
		Location = location;
		ElevatorID = elevatorIDl;
		Status = status;
	}
	public HotelDTO() {
		super();
	}
	public Long getHotelID() {
		return HotelID;
	}
	public void setHotelID(Long hotelID) {
		HotelID = hotelID;
	}
	public String getHotelName() {
		return HotelName;
	}
	public void setHotelName(String hotelName) {
		HotelName = hotelName;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public Long getElevatorIDl() {
		return ElevatorID;
	}
	public void setElevatorIDl(Long elevatorIDl) {
		ElevatorID= elevatorIDl;
	}
	public ElevatorStatus getStatus() {
		return Status;
	}
	public void setStatus(ElevatorStatus status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "HotelDTO [HotelID=" + HotelID + ", HotelName=" + HotelName + ", Location=" + Location + ", ElevatorIDl="
				+ ElevatorID + ", Status=" + Status + "]";
	}
}
