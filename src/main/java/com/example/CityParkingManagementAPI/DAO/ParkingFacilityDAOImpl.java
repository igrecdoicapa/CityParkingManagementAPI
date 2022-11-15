package com.example.CityParkingManagementAPI.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.CityParkingManagementAPI.Entity.City;
import com.example.CityParkingManagementAPI.Entity.ParkingFacility;

@Repository
public class ParkingFacilityDAOImpl implements IParkingFacilityDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void save(ParkingFacility parkingFacility) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(parkingFacility);
		
	}
	
	@Override
	public ParkingFacility getParkingFacilityById(String id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<ParkingFacility> theQuery = currentSession.createQuery("from ParkingFacility where id=:id");
		
		theQuery.setParameter("id", id);
		if(theQuery.getResultList().size() == 0) {
			return null;
		}
		ParkingFacility parkingFacility = theQuery.getResultList().get(0);
		return parkingFacility;
	}

	@Override
	public List<ParkingFacility> getParkingFacilitiesByCity(int cityId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<ParkingFacility> theQuery = currentSession.createQuery("from ParkingFacility where id_city=:cityId");
		
		theQuery.setParameter("cityId", cityId);
		
		if(theQuery.getResultList().size() == 0) {
			return null;
		}
		return theQuery.getResultList();
	}

	

}
