package com.CentralElevatorManagement.Application.Controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.CentralElevatorManagement.Application.Entity.ElevatorHistory;
import com.CentralElevatorManagement.Application.Service.copy.ElevatorHistoryService;


/**
 * @author krishnakumar
 * /history/hotel/{hotelId}/elevtor/{elevator_id
 * /elevator/{elevatorId}
 */
@RestController
@RequestMapping("/history")
public class HistoryReportController {

    @Autowired
    private ElevatorHistoryService elevatorHistoryService;
    
    
    @GetMapping("/hotel/{HotelId}/elevtor/{elevatorId}")
    public Map<String, String> getHistoryOfTravelled(@PathVariable Long HotelId,@PathVariable Long elevatorId,
    		    @RequestParam LocalDateTime startTime,@RequestParam LocalDateTime endTime){
    	ElevatorHistory history = elevatorHistoryService.getHistory(HotelId, elevatorId, startTime, endTime);
    	Map<String, String> map= new HashMap<>();
    	history.getId().toString();
    	map.put("HistoryId", history.getId().toString());
    	map.put("Elevator", history.getElevator().toString());
    	map.put("StartTime", startTime.toString());
    	map.put("EndTime", endTime.toString());
    	if(history.getFloors_travelled() ==null) {
    	map.put("FloorsTravelled","12");
    	}else {
    		map.put("FloorsTravelled", history.getFloors_travelled().toString());
    	}
    	
    	return map;
    }
}