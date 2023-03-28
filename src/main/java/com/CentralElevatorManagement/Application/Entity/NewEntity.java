package com.CentralElevatorManagement.Application.Entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author krishnakumar
 *
 */
//@Component
@Entity
@Table
public class NewEntity {

	@Id
	private Long id;
	@Column
	private String name;
	@Column
	private String Location;
	@Column
	private boolean status;
	
	
	
}
