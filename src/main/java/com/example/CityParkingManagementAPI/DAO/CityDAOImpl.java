package com.example.CityParkingManagementAPI.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.CityParkingManagementAPI.Entity.City;
@Repository
public class CityDAOImpl implements ICityDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void save(City city) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(city);
	}

	@Override
	public City getById(String id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<City> theQuery = currentSession.createQuery("from City where id=:id");
		
		theQuery.setParameter("id", id);
		if(theQuery.getResultList().size() == 0) {
			return null;
		}
		City city = theQuery.getResultList().get(0);
		return city;
	}

	@Override
	public City getByCode(String code) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<City> theQuery = currentSession.createQuery("from City where code=:code");
		
		theQuery.setParameter("code", code);
		if(theQuery.getResultList().size() == 0) {
			return null;
		}
		City city = theQuery.getResultList().get(0);
		return city;
	}

	@Override
	public List<City> getAllCities() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<City> theQuery = currentSession.createQuery("from City", City.class);
		
		List<City> cities = theQuery.getResultList();
		return cities;
	}

}
