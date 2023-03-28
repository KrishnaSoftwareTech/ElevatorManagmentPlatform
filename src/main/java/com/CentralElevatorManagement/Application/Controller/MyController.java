package com.CentralElevatorManagement.Application.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author krishnakumar
 * http://localhost:9091/
 */
@RestController
@RequestMapping
public class MyController {
	
	@GetMapping("/{str}")
	public Boolean getInfo(@PathVariable String str) {
		if(str.equals("true")) {
			return true;
		}
		else {
			return false;
		}
	}

}
