package com.CentralElevatorManagement.Application.Entity;


/**
 * @author krishnakumar
 *
 */
//@Component

public class ElevatorDTO {
  
	private Long ElevatorID;
	private Long HotelID;
	private String HotelName;
	private ElevatorStatus ElevatorStatus;
	private Integer CurrentFloor;
	public ElevatorDTO(Long elevatorID, Long hotelID, String hotelName, ElevatorStatus elevatorStatus, Integer currentFloor) {
		super();
		ElevatorID = elevatorID;
		HotelID = hotelID;
		HotelName = hotelName;
		ElevatorStatus = elevatorStatus;
		CurrentFloor = currentFloor;
	}

		public ElevatorDTO() {
			super();
		}

		public Long getElevatorID() {
			return ElevatorID;
		}

		public void setElevatorID(Long elevatorID) {
			ElevatorID = elevatorID;
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

		public ElevatorStatus getElevatorStatus() {
			return ElevatorStatus;
		}

		public void setElevatorStatus(ElevatorStatus elevatorStatus2) {
			ElevatorStatus = elevatorStatus2;
		}

		public Integer getCurrentFloor() {
			return CurrentFloor;
		}

		public void setCurrentFloor(Integer integer) {
			CurrentFloor = integer;
		}

		@Override
		public String toString() {
			return "ElevatorDTO [ElevatorID=" + ElevatorID + ", HotelID=" + HotelID + ", HotelName=" + HotelName
					+ ", ElevatorStatus=" + ElevatorStatus + ", CurrentFloor=" + CurrentFloor + "]";
		}
	
	
}
