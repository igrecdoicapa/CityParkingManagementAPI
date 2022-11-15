package com.example.CityParkingManagementAPI.DAO;

import java.util.List;

import com.example.CityParkingManagementAPI.Entity.City;
import com.example.CityParkingManagementAPI.Entity.ParkingFacility;

public interface IParkingFacilityDAO {
	public void save(ParkingFacility parkingFacility);
	public ParkingFacility getParkingFacilityById(String id);
	public List<ParkingFacility> getParkingFacilitiesByCity(int cityId);
}
