package com.CentralElevatorManagement.Application.Entity;

/**
 * @author krishnakumar
 *
 */

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/**
 * @author krishnakumar
 *
 */
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String location;
    
    @OneToMany(mappedBy = "hotel")
    private List<Elevator> elevators;
    
    public Hotel() {
    	super();
    }

	/**
	 * @param id
	 * @param name
	 * @param location
	 * @param elevators
	 */
	public Hotel(Long id, String name, String location, List<Elevator> elevators) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.elevators = elevators;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Elevator> getElevators() {
		return elevators;
	}

	public void setElevators(List<Elevator> elevators) {
		this.elevators = elevators;
	}
    
}