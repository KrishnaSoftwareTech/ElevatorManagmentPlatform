package com.CentralElevatorManagement.Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CentralElevatorManagement.Application.Entity.Elevator;

/**
 * @author krishnakumar
 *
 */
@Repository
public interface ElevatorRepository extends JpaRepository<Elevator, Long>{

	
}
