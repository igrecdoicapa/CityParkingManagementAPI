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
import com.example.CityParkingManagementAPI.Service.ICityService;

@RestController
@RequestMapping("/api")
public class CityController {
	
	private ICityService cityService;

	@Autowired
	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}
	
	@PostMapping("/city")
	public City addCity(@RequestBody City city) {
		city.setIntId(0);
		
		try {
			cityService.save(city);
		} catch(Exception e) {
			if(e.getMessage().contains("constraint [city.")){
				throw new RuntimeException("City already exists");
			} else {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return city;
	}
	
	@GetMapping("/city/byId/{cityId}")
	public City getCityById(@PathVariable String cityId) {
		City city = cityService.getById(cityId);
		if(city == null) {
			throw new RuntimeException("City with the following id not found: - " + cityId);
		}

		return city;
	}
	
	@GetMapping("/city/byCode/{cityCode}")
	public City getCityByCode(@PathVariable String cityCode) {
		City city = cityService.getByCode(cityCode);
		if(city == null) {
			throw new RuntimeException("City with the following code not found: - " + cityCode);
		}

		return city;
	}
	
	@GetMapping("city/all")
	public List<City> getAllCities(){
		List<City> cities = cityService.getAllCities();
		return cities;
	}
	
	
}
