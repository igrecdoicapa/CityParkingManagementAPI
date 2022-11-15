package com.example.CityParkingManagementAPI.DAO;

import java.util.List;

import com.example.CityParkingManagementAPI.Entity.Vehicle;

public interface IVehicleDAO {
	
	public void save(Vehicle vehicle);
	public List<Vehicle> getVehiclesByCityIntId(int cityId);
	public Vehicle getById(String id);
}
