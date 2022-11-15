package com.example.CityParkingManagementAPI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.CityParkingManagementAPI.DAO.IParkingFacilityDAO;
import com.example.CityParkingManagementAPI.Entity.City;
import com.example.CityParkingManagementAPI.Entity.ParkingFacility;

@Service
public class ParkingFacilityServiceImpl implements IParkingFacilityService {
	
	@Autowired
	private IParkingFacilityDAO parkingFacilityDAO;
	
	@Override
	@Transactional
	public void save(ParkingFacility parkingFacility) {
		parkingFacilityDAO.save(parkingFacility);
	}
	
	@Override
	@Transactional
	public ParkingFacility getParkingFacilityById(String id) {
		return parkingFacilityDAO.getParkingFacilityById(id);
	}

	@Override
	@Transactional
	public List<ParkingFacility> getParkingFacilitiesByCity(int cityId) {
		return parkingFacilityDAO.getParkingFacilitiesByCity(cityId);
	}

}
