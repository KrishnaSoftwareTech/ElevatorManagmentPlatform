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
	
    public ElevatorHistory findByElevatorId(Long elevator_id);
}
