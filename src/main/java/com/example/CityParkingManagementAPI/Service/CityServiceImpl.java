package com.example.CityParkingManagementAPI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.CityParkingManagementAPI.DAO.ICityDAO;
import com.example.CityParkingManagementAPI.Entity.City;

@Service
public class CityServiceImpl implements ICityService {
	
	@Autowired
	private ICityDAO cityDAO;
	
	@Override
	@Transactional
	public void save(City city) {
		cityDAO.save(city);
		
	}

	@Override
	@Transactional
	public City getById(String id) {
		return cityDAO.getById(id);
	}

	@Override
	@Transactional
	public City getByCode(String code) {
		return cityDAO.getByCode(code);
	}

	@Override
	@Transactional
	public List<City> getAllCities() {
		return cityDAO.getAllCities();
	}

}
