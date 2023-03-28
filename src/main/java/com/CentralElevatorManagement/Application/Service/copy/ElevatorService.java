package com.CentralElevatorManagement.Application.Service.copy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CentralElevatorManagement.Application.Entity.Elevator;
import com.CentralElevatorManagement.Application.Entity.Hotel;
import com.CentralElevatorManagement.Application.Repository.ElevatorRepository;
import com.CentralElevatorManagement.Application.Repository.HotelRepository;

import jakarta.persistence.EntityNotFoundException;

/**
 * @author krishnakumar
 *
 */
@Service
public class ElevatorService {
	@Autowired
	private ElevatorRepository  elevatorRepository;
	@Autowired
	private HotelRepository hotelRepository;
	

	public Map<String, String> gotoFloor(Long hotelId, Long elevatorId, Integer floorNumber) {
		Map<String, String> map =new HashMap<>();
		Hotel hotel = hotelRepository.findById(hotelId)
				  .orElseThrow( () -> new EntityNotFoundException("Hotel Not Found"));
		Elevator elevator = elevatorRepository.findById(elevatorId)
		   .orElseThrow(() -> new EntityNotFoundException("Elevator Not Found"));
//		map.put("Elevator_Id", elevator.getId().toString());
//		map.put("CurrentFloor", elevator.getCurrentFloor().toString());
//		map.put("Destination Floor", elevator.getStatus().toString());
//		map.put("In Hotel", elevator.getHotel().toString());
//		map.put("--- Have a Nice Day !", "----");
		if(!hotel.getElevators().contains(elevator)) {
			throw new IllegalArgumentException("Elevator does not belong to the specified hotel");
		}
		else {
			elevator.gotoFloor(floorNumber);
	        elevatorRepository.save(elevator);
	        map.put("Elevator_Id", elevator.getId().toString());
			map.put("CurrentFloor", elevator.getCurrentFloor().toString());
			map.put("Destination Floor", elevator.getDestinationFloor().toString());
			map.put("Status Of Elevator", elevator.getStatus().toString());
			map.put("In Hotel", elevator.getHotel().getId().toString());
			map.put("--- Have a Nice Day !", "Have a Nice Day !----");
		}
		return map;
		
	}

}
