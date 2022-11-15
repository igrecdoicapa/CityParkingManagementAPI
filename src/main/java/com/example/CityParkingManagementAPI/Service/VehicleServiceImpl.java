package com.example.CityParkingManagementAPI.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.CityParkingManagementAPI.DAO.IVehicleDAO;
import com.example.CityParkingManagementAPI.Entity.Vehicle;

@Service
public class VehicleServiceImpl implements IVehicleService {
	
	@Autowired
	private IVehicleDAO vehicleDAO;
	
	@Override
	@Transactional
	public void save(Vehicle vehicle) {
		vehicleDAO.save(vehicle);
	}

	@Override
	@Transactional
	public List<Vehicle> getVehiclesByCityIntId(int cityId) {
		return vehicleDAO.getVehiclesByCityIntId(cityId);
	}
	
	@Override
	@Transactional
	public Vehicle getById(String id) {
		return vehicleDAO.getById(id);
	}
	
	@Override
	@Transactional
	public void park(Vehicle vehicle) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unpark(Vehicle vehicle) {
		// TODO Auto-generated method stub

	}



}
