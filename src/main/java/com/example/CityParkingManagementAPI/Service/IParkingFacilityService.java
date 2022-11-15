package com.example.CityParkingManagementAPI.Service;

import java.util.List;

import com.example.CityParkingManagementAPI.Entity.City;
import com.example.CityParkingManagementAPI.Entity.ParkingFacility;

public interface IParkingFacilityService {
	
	public void save(ParkingFacility parkingFacility);
	public ParkingFacility getParkingFacilityById(String id);
	public List<ParkingFacility> getParkingFacilitiesByCity(int cityId);
}
