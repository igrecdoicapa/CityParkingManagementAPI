package com.example.CityParkingManagementAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CityParkingManagementAPI.Entity.City;
import com.example.CityParkingManagementAPI.Entity.ParkingFacility;
import com.example.CityParkingManagementAPI.Entity.Vehicle;
import com.example.CityParkingManagementAPI.Service.ICityService;
import com.example.CityParkingManagementAPI.Service.IParkingFacilityService;
import com.example.CityParkingManagementAPI.Service.IVehicleService;

@RestController
@RequestMapping("/api")
public class VehicleController {
	
	private IVehicleService vehicleService;
	private IParkingFacilityService parkingFacilityService;
	private ICityService cityService;

	@Autowired
	public VehicleController(IVehicleService vehicleService, IParkingFacilityService parkingFacilityService, ICityService cityService) {
		this.vehicleService = vehicleService;
		this.parkingFacilityService = parkingFacilityService;
		this.cityService = cityService;
	}
	
	@PostMapping("/vehicleBike/{cityId}")
	public Vehicle addVehicleBike(@RequestBody Vehicle vehicle, @PathVariable String cityId) {
		
		City city = cityService.getById(cityId);
		
		vehicle.setCity(city);
		vehicle.setVehicleType("B");
		
		try {
			vehicleService.save(vehicle);
		} catch(Exception e) {
			if(e.getMessage().contains("constraint [vehicle.")){
				throw new RuntimeException("Vehicle already exists");
			} else {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return vehicle;
		
	}
	
	@PostMapping("/vehicleCar/{cityId}")
	public Vehicle addVehicleCar(@RequestBody Vehicle vehicle, @PathVariable String cityId) {
		
		City city = cityService.getById(cityId);
		
		vehicle.setCity(city);
		vehicle.setVehicleType("C");
			
		try {
			vehicleService.save(vehicle);
		} catch(Exception e) {
			if(e.getMessage().contains("constraint [vehicle.")){
				throw new RuntimeException("Vehicle already exists");
			} else {
				throw new RuntimeException(e.getMessage());
			}
		}
			
		return vehicle;
	}
	
	@GetMapping("/vehicle/{cityCode}")
	public List<Vehicle> getVehiclesByCityCode(@PathVariable String cityCode){
		City city = cityService.getByCode(cityCode);
		List<Vehicle> vehicles = vehicleService.getVehiclesByCityIntId(city.getIntId());
		for(Vehicle vehicle : vehicles) {
			if(vehicle.isParked()) {
				vehicle.setParkingFacilityId(vehicle.getParkingFacility().getId());
			}
		}
		return vehicles;
	}
	
	@PutMapping("/vehicle/park")
	public Vehicle parkVehicle(@RequestBody Vehicle tempVehicle) {
		
		ParkingFacility parkingFacility = parkingFacilityService.getParkingFacilityById(tempVehicle.getParkingFacilityId());
		Vehicle vehicle = vehicleService.getById(tempVehicle.getId());
		
		if(parkingFacility.getAvailableCapacity() == 0) {
			throw new RuntimeException("Capacity is full");
		}
		if(vehicle.isParked()) {
			throw new RuntimeException("Vehicle already parked");
		}
		
		if(parkingFacility.getParkingType().equals(vehicle.getVehicleType())) {
			vehicle.setParkingFacility(parkingFacility);
			vehicle.setParked(true);
			vehicle.setParkingFacilityId(tempVehicle.getParkingFacilityId());
			parkingFacility.setAvailableCapacity(parkingFacility.getAvailableCapacity() - 1);
			
			parkingFacilityService.save(parkingFacility);
			try {
				vehicleService.save(vehicle);
			} catch(Exception e) {
				if(e.getMessage().contains("constraint [vehicle.")){
					throw new RuntimeException("Vehicle facility already exists");
				} else {
					throw new RuntimeException(e.getMessage());
				}
			}
			
			
			return vehicle;
		} else {
			throw new RuntimeException("Vehicle type not accepted here");
		}
	}
	
	@PutMapping("/vehicle/unpark")
	public Vehicle unparkVehicle(@RequestBody Vehicle tempVehicle) {
		Vehicle vehicle = vehicleService.getById(tempVehicle.getId());
		
		if(!vehicle.isParked()) {
			throw new RuntimeException("Vehicle already not parked");
		}
		
		ParkingFacility parkingFacility = vehicle.getParkingFacility();
		
		vehicle.setParked(false);
		vehicle.setParkingFacilityId(null);
		parkingFacility.setAvailableCapacity(parkingFacility.getAvailableCapacity() + 1);
		vehicle.setParkingFacility(null);
		
		parkingFacilityService.save(parkingFacility);
		try {
			vehicleService.save(vehicle);
		} catch(Exception e) {
			if(e.getMessage().contains("constraint [vehicle.")){
				throw new RuntimeException("Vehicle facility already exists");
			} else {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return vehicle;
	}
}
