package com.example.CityParkingManagementAPI.Service;

import java.util.List;

import com.example.CityParkingManagementAPI.Entity.City;

public interface ICityService {
	
	public void save(City city);
	public City getById(String id);
	public City getByCode(String code);
	public List<City> getAllCities();
}
