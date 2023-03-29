package com.CentralElevatorManagement.Application.Controller;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CentralElevatorManagement.Application.Entity.ElevatorDTO;
import com.CentralElevatorManagement.Application.Entity.ElevatorStatus;

import com.CentralElevatorManagement.Application.Entity.HotelDTO;
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
	
	//Obtain a list of all elevators and all hotels managed by this platform
	@GetMapping("elevators")
    public ResponseEntity<Set<ElevatorDTO>> getAllElevators() {
		Set<ElevatorDTO> listElevators = elevatorService.getListElevators();
        return ResponseEntity.ok(listElevators);
    }
    @GetMapping("/elevators/{elevatorId}")
    public ElevatorDTO getElevator(@PathVariable Long elevatorId) {
    	ElevatorDTO elevatorByID = elevatorService.getElevatorByID(elevatorId);
    	return elevatorByID;
    }
    @GetMapping("/hotels")
    public Set<HotelDTO> getAllHotels() {
    	Set<HotelDTO> listHotels = elevatorService.getListHotels();
        return listHotels;
        }

    @GetMapping("/hotels/{hotelId}")
    public HotelDTO getHotel(@PathVariable Long hotelId) {
    	HotelDTO hotelByID = elevatorService.getHotelByID(hotelId);
        return hotelByID;
    }
    
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
