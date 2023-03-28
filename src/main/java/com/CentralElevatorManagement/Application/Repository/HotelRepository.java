package com.CentralElevatorManagement.Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CentralElevatorManagement.Application.Entity.Hotel;

/**
 * @author krishnakumar
 *
 */
public interface HotelRepository extends JpaRepository<Hotel, Long>{

}
