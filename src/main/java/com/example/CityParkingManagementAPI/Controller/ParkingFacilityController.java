package com.example.CityParkingManagementAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CityParkingManagementAPI.Entity.City;
import com.example.CityParkingManagementAPI.Entity.ParkingFacility;
import com.example.CityParkingManagementAPI.Service.ICityService;
import com.example.CityParkingManagementAPI.Service.IParkingFacilityService;

@RestController
@RequestMapping("/api")
public class ParkingFacilityController {
	
	private IParkingFacilityService parkingFacilityService;
	private ICityService cityService;
	

	@Autowired
	public ParkingFacilityController(IParkingFacilityService parkingFacilityService, ICityService cityService) {
		this.parkingFacilityService = parkingFacilityService;
		this.cityService = cityService;
	}
	
	@PostMapping("/parkingFacilityBike")
	public ParkingFacility addParkingFacilityBike(@RequestBody ParkingFacility parkingFacility){
		parkingFacility.setParkingType("B");
		City city = cityService.getById(parkingFacility.getCity().getId());
		if(city == null) {
			throw new RuntimeException("City with the following id not found: - " + parkingFacility.getCity().getId());
		}
		parkingFacility.setCity(city);
		
		try {
			parkingFacilityService.save(parkingFacility);
		} catch(Exception e) {
			if(e.getMessage().contains("constraint [parking_facility.")){
				throw new RuntimeException("Parking facility already exists");
			} else {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return parkingFacility;
	}
	
	@PostMapping("/parkingFacilityCar")
	public ParkingFacility addParkingFacilityVehicle(@RequestBody ParkingFacility parkingFacility){
		City city = cityService.getById(parkingFacility.getCity().getId());
		parkingFacility.setParkingType("C");
		if(city == null) {
			throw new RuntimeException("City with the following id not found: - " + parkingFacility.getCity().getId());
		}
		parkingFacility.setCity(city);
		
		try {
			parkingFacilityService.save(parkingFacility);
		} catch(Exception e) {
			if(e.getMessage().contains("constraint [parking_facility.")){
				throw new RuntimeException("Parking facility already exists");
			} else {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return parkingFacility;
	}
	
	@GetMapping("/parkingFacility/{parkingFacilityId}")
	public  ParkingFacility getParkingFacilityById(@PathVariable String parkingFacilityId) {
		ParkingFacility parkingFacility = parkingFacilityService.getParkingFacilityById(parkingFacilityId);
		if(parkingFacility == null) {
			throw new RuntimeException("Parking facility with the following id not found: - " + parkingFacilityId);
		}

		return parkingFacility;
	}
	
	@GetMapping("/parkingFacility/all/{cityId}")
	public List<ParkingFacility> getAllParkingFacilities(@PathVariable String cityId){
		
		City city = cityService.getById(cityId);
		List<ParkingFacility> parkingFacilities = parkingFacilityService.getParkingFacilitiesByCity(city.getIntId());
		
		return parkingFacilities;
	}
	
}
