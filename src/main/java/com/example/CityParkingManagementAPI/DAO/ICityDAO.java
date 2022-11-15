package com.example.CityParkingManagementAPI.DAO;

import java.util.List;

import com.example.CityParkingManagementAPI.Entity.City;

public interface ICityDAO {
	
	public void save(City city);
	public City getById(String id);
	public City getByCode(String code);
	public List<City> getAllCities();

}
