package com.CentralElevatorManagement.Application.Controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CentralElevatorManagement.Application.Entity.Elevator;
import com.CentralElevatorManagement.Application.Entity.ElevatorStatus;
import com.CentralElevatorManagement.Application.Repository.ElevatorRepository;
import com.CentralElevatorManagement.Application.Service.copy.ElevatorService;

import jakarta.persistence.EntityNotFoundException;


/**
 * @author krishnakumar
 *
 */
@RestController
@RequestMapping("/ElevatorService")
public class ElevatorController {
	
	@Autowired
	private ElevatorService elevatorService;
		
	@PostMapping("/hotels/{hotelId}/elevators/{elevatorId}/{floorNumber}")
	public ResponseEntity<Map<String, String>> gotoFloor(
	        @PathVariable Long hotelId,
	        @PathVariable Long elevatorId,
	        @PathVariable Integer floorNumber
	    ) {  
	    	  Map<String, String> gotoFloor = elevatorService.gotoFloor(hotelId, elevatorId, floorNumber);
	       if(gotoFloor== null) {
	         throw new EntityNotFoundException("Elevator Not Found or" + ElevatorStatus.OUT_OF_SERVICE);
		     }
	         return ResponseEntity.ok(gotoFloor);
	     }

}
