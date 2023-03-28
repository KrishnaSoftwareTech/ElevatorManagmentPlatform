package com.CentralElevatorManagement.Application.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CentralElevatorManagement.Application.Entity.ElevatorHistory;
import com.CentralElevatorManagement.Application.Entity.ElevatorHistoryDTO;

/**
 * @author krishnakumar
 *
 */
public interface ElevatorHistoryRepository  extends JpaRepository<ElevatorHistory, Long>{
//	List<ElevatorHistoryDTO> findByElevator_Hotel_IdAndTravelTimeBetween(Long hotelId, LocalDateTime startTime, LocalDateTime endTime);
//
//    List<ElevatorHistoryDTO> findByElevator_IdAndTravelTimeBetween(Long elevatorId, LocalDateTime startTime, LocalDateTime endTime);

	public ElevatorHistory findByElevatorId(Long elevator_id);

}
