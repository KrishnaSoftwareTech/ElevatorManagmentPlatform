package com.CentralElevatorManagement.Application.Service.copy;

/**
 * @author krishnakumar
 *
 */
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CentralElevatorManagement.Application.Entity.Elevator;
import com.CentralElevatorManagement.Application.Entity.ElevatorHistory;
import com.CentralElevatorManagement.Application.Entity.ElevatorHistoryDTO;
import com.CentralElevatorManagement.Application.Entity.Hotel;
import com.CentralElevatorManagement.Application.Repository.ElevatorHistoryRepository;
import com.CentralElevatorManagement.Application.Repository.ElevatorRepository;
import com.CentralElevatorManagement.Application.Repository.HotelRepository;

import jakarta.persistence.EntityNotFoundException;
@Service
public class ElevatorHistoryService {
		
		@Autowired
	    private  ElevatorHistoryRepository elevatorHistoryRepository;
	    @Autowired
	    private ElevatorRepository elevatorRepository;
	    @Autowired
	    private HotelRepository hotelRepository;
		//find hotel by id , --- and find elevaor ----> if both present , then find history
		
		
		public ElevatorHistory getHistory(Long hotel_id,Long elevator_id, LocalDateTime startTime, LocalDateTime endTime) {
			ElevatorHistory elevatorHistory;
			Elevator elevator = elevatorRepository.findById(elevator_id).orElseThrow( () ->  new EntityNotFoundException("Elevator Not Found"));
			Hotel hotel = hotelRepository.findById(hotel_id).orElseThrow( () -> new EntityNotFoundException("Hotel Not found "));
			if(elevator == null && hotel ==null) {
				throw new EntityNotFoundException("Hotel And Elevator Not Found");
			}
			else {
				//find by elevator id 
				 elevatorHistory = elevatorHistoryRepository.findByElevatorId(elevator_id); //.findByElevatorId(elevator_id);
			}
			return elevatorHistory;
		}
	
//	    public List<ElevatorHistoryDTO> getElevatorHistoryByHotelIdAndPeriod(Long hotelId, LocalDateTime startTime, LocalDateTime endTime) {
//	    //	elevatorHistoryRepository.findAllById(null)
//	        return elevatorHistoryRepository.findByElevator_Hotel_IdAndTravelTimeBetween(hotelId, startTime, endTime);
//	    }
//	    public List<ElevatorHistoryDTO> getElevatorHistoryByElevatorIdAndPeriod(Long elevatorId, LocalDateTime startTime, LocalDateTime endTime) {
//	        return elevatorHistoryRepository.findByElevator_IdAndTravelTimeBetween(elevatorId, startTime, endTime);
//	    }
}