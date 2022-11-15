package com.example.CityParkingManagementAPI.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.CityParkingManagementAPI.Entity.ParkingFacility;
import com.example.CityParkingManagementAPI.Entity.Vehicle;

@Repository
public class VehicleDAOImpl implements IVehicleDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void save(Vehicle vehicle) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(vehicle);
	}
	
	@Override
	public List<Vehicle> getVehiclesByCityIntId(int cityId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Vehicle> theQuery = currentSession.createQuery("from Vehicle where id_city=:cityId");
		
		theQuery.setParameter("cityId", cityId);
		
		if(theQuery.getResultList().size() == 0) {
			return null;
		}
		return theQuery.getResultList();
	}
	
	@Override
	public Vehicle getById(String id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Vehicle> theQuery = currentSession.createQuery("from Vehicle where id=:id");
		
		theQuery.setParameter("id", id);
		if(theQuery.getResultList().size() == 0) {
			return null;
		}
		Vehicle vehicle = theQuery.getResultList().get(0);
		return vehicle;
	}


}
