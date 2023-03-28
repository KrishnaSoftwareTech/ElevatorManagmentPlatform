package com.CentralElevatorManagement.Application.Entity;

/**
 * @author krishnakumar
 *
 */

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "elevator_history")
public class ElevatorHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   ///elevator id
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "elevator_id")
    private Elevator elevator;
    
//    @Column(name = "start_floor")
//    private int startFloor;
//    
//    @Column(name = "end_floor")
//    private int endFloor;
    
    @Column(name = "start_Time")
    private LocalDateTime startTime;
    
    @Column(name = "end_Time")
    private LocalDateTime endtime;

    @Column(name="Number_of_Floors_travelled")
    private Long Floors_travelled;

	public ElevatorHistory(Long id, Elevator elevator, LocalDateTime startTime, LocalDateTime endtime,
			Long floors_travelled) {
		super();
		this.id = id;
		this.elevator = elevator;
		this.startTime = startTime;
		this.endtime = endtime;
		Floors_travelled = floors_travelled;
	}
	public ElevatorHistory() {
		super();
	}
	@Override
	public String toString() {
		return "ElevatorHistory [id=" + id + ", elevator=" + elevator + ", startTime=" + startTime + ", endtime="
				+ endtime + ", Floors_travelled=" + Floors_travelled + "]";
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Elevator getElevator() {
		return elevator;
	}

	public void setElevator(Elevator elevator) {
		this.elevator = elevator;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndtime() {
		return endtime;
	}

	public void setEndtime(LocalDateTime endtime) {
		this.endtime = endtime;
	}

	public Long getFloors_travelled() {
		return Floors_travelled;
	}

	public void setFloors_travelled(Long floors_travelled) {
		Floors_travelled = floors_travelled;
	}
}