package com.CentralElevatorManagement.Application.Service.copy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CentralElevatorManagement.Application.Entity.Elevator;
import com.CentralElevatorManagement.Application.Entity.ElevatorDTO;
import com.CentralElevatorManagement.Application.Entity.Hotel;
import com.CentralElevatorManagement.Application.Entity.HotelDTO;
import com.CentralElevatorManagement.Application.Repository.ElevatorRepository;
import com.CentralElevatorManagement.Application.Repository.HotelRepository;

import jakarta.persistence.EntityNotFoundException;

/**
 * @author krishnakumar
 * //
 */
@Service
public class ElevatorService {
	@Autowired
	private ElevatorRepository  elevatorRepository;
	@Autowired
	private HotelRepository hotelRepository;
	 ElevatorDTO Elevatordata=new ElevatorDTO();
	 HotelDTO  HotelData=new HotelDTO();

	public Map<String, String> gotoFloor(Long hotelId, Long elevatorId, Integer floorNumber) {
		Map<String, String> map =new HashMap<>();
		Hotel hotel = hotelRepository.findById(hotelId)
				  .orElseThrow( () -> new EntityNotFoundException("Hotel Not Found"));
		Elevator elevator = elevatorRepository.findById(elevatorId)
		   .orElseThrow(() -> new EntityNotFoundException("Elevator Not Found"));
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

  //list of elevators
	public Set<ElevatorDTO> getListElevators() {
		List<Elevator> listElevators= elevatorRepository.findAll();
		Set<ElevatorDTO> set = new HashSet<>();
		if(listElevators.isEmpty()) {
			throw new EntityNotFoundException("Elevators History Not Found");
		}else {
			try {
			for(Elevator elevator:listElevators) {
				setDataTransferObjects(elevator);
				set.add(Elevatordata);
			  }}catch (Exception e) {
				throw new InternalError("Data Object Error");
				}
			}
		
		return set;
	}

	private ElevatorDTO setDataTransferObjects(Elevator elevator) {
         Elevatordata.setElevatorID(elevator.getId());
         Elevatordata.setHotelID(elevator.getHotel().getId());
         Elevatordata.setHotelName(elevator.getHotel().getName());
		Elevatordata.setElevatorStatus(elevator.getStatus());
		Elevatordata.setCurrentFloor(elevator.getCurrentFloor());
		return Elevatordata;
	}

  //elevator by id
	public ElevatorDTO getElevatorByID(Long elevatorId) {
	    ElevatorDTO setDataTransferObjects ;
		  Elevator elevator = elevatorRepository.findById(elevatorId)
                 .orElseThrow(() -> new EntityNotFoundException("Elevator not found"));
		  try {
		        setDataTransferObjects = setDataTransferObjects(elevator);
		  }catch (Exception e) {
			  throw new InternalError("Data Object Error");
		}
		return setDataTransferObjects;	
	}

	//getAll Hotels
	public Set<HotelDTO> getListHotels() {
		List<Hotel> allHotels = hotelRepository.findAll();
		Set<HotelDTO> hotelDto=new HashSet<>();
		for (Hotel hotel : allHotels) {
				HotelDTO setDataTransferObjectsByHotel = setDataTransferObjectsByHotel(hotel);
				hotelDto.add(setDataTransferObjectsByHotel);
			}
		return hotelDto;
	}
	
	private HotelDTO setDataTransferObjectsByHotel(Hotel hotel) {
        HotelData.setHotelID(hotel.getId());
        HotelData.setElevatorIDl(hotel.getElevators().get(0).getId());
        HotelData.setHotelName(hotel.getName());
        HotelData.setStatus(hotel.getElevators().get(0).getStatus());
		HotelData.setLocation(hotel.getLocation());
		return HotelData;
	}

	//get Hotel By Id
	public HotelDTO getHotelByID(Long hotelId) {
		HotelDTO hotelData = null;
		Hotel hotel = hotelRepository.findById(hotelId).orElseThrow( () -> new EntityNotFoundException("Hotel Not Found For " +hotelId));
		if(hotel != null) {
			 hotelData= setDataTransferObjectsByHotel(hotel);
		}
		return hotelData;
	}

}
