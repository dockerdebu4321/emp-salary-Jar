package com.ey.practice.SpringBootPractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.practice.SpringBootPractice.bean.VehicleBean;
import com.ey.practice.SpringBootPractice.service.VehicleService;

@RestController
@RequestMapping(path="/vehicle")
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService; 
	
	@Value("${welcome.message}")
    private String welcomeMessage;
	
	
	@GetMapping(path="/Welcome")
	public String WelcomeMessage() {
		
		return welcomeMessage;
	}
	
	
	
	@GetMapping(path="/getAllVehicleDetails")
	public List<VehicleBean> getAllVehicle() {
		List<VehicleBean> vehList = vehicleService.getAllVehicle();
		return vehList;
	}

}
