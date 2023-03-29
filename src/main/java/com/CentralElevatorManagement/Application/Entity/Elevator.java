package com.CentralElevatorManagement.Application.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author krishnakumar
 *
 */
@Entity
@Table
public class Elevator {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false)
    @JsonManagedReference
    private Hotel hotel;

    @Enumerated(EnumType.STRING)
    private ElevatorStatus status;

    @Column(name = "current_floor")
    private Integer currentFloor;

    @Column(name = "destination_floor")
    private Integer destinationFloor;

    @OneToMany(mappedBy = "elevator", cascade = CascadeType.ALL)
    private List<Button> insideButtons;

    @OneToMany(mappedBy = "elevator", cascade = CascadeType.ALL)
    private List<Button> outsideButtons;

    public void gotoFloor(Integer floorNumber) {
        destinationFloor = floorNumber;
        status = ElevatorStatus.MOVING;
    }
    
    

	public Elevator(Long id, Hotel hotel, ElevatorStatus status, Integer currentFloor, Integer destinationFloor,
			List<Button> insideButtons, List<Button> outsideButtons) {
		super();
		this.id = id;
		this.hotel = hotel;
		this.status = status;
		this.currentFloor = currentFloor;
		this.destinationFloor = destinationFloor;
		this.insideButtons = insideButtons;
		this.outsideButtons = outsideButtons;
	}

public Elevator() {
	
}
//
	public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Hotel getHotel() {
	return hotel;
}

public void setHotel(Hotel hotel) {
	this.hotel = hotel;
}
public ElevatorStatus getStatus() {
	return status;
}

public void setStatus(ElevatorStatus status) {
	this.status = status;
}

public Integer getCurrentFloor() {
	return currentFloor;
}
public void setCurrentFloor(Integer currentFloor) {
	this.currentFloor = currentFloor;
}
public Integer getDestinationFloor() {
	return destinationFloor;
}
public void setDestinationFloor(Integer destinationFloor) {
	this.destinationFloor = destinationFloor;
}

public List<Button> getInsideButtons() {
	return insideButtons;
}
public void setInsideButtons(List<Button> insideButtons) {
	this.insideButtons = insideButtons;
}
public List<Button> getOutsideButtons() {
	return outsideButtons;
}
public void setOutsideButtons(List<Button> outsideButtons) {
	this.outsideButtons = outsideButtons;
}
	@Override
	public String toString() {
		return "Elevator [id=" + id + ", hotel=" + hotel + ", status=" + status + ", currentFloor=" + currentFloor
				+ ", destinationFloor=" + destinationFloor + ", insideButtons=" + insideButtons + ", outsideButtons="
				+ outsideButtons + "]";
	}

}
