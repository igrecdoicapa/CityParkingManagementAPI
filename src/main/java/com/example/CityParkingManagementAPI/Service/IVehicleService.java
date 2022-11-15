package com.example.CityParkingManagementAPI.Service;

import java.util.List;

import com.example.CityParkingManagementAPI.Entity.Vehicle;

public interface IVehicleService {
	
	public void save(Vehicle vehicle);
	public List<Vehicle> getVehiclesByCityIntId(int cityId);
	public Vehicle getById(String id);
	public void park(Vehicle vehicle);
	public void unpark(Vehicle vehicle);
}
