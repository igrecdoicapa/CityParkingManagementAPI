package com.example.CityParkingManagementAPI.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="parking_facility")
public class ParkingFacility {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="int_id")
	@JsonIgnore
	private int intId;
	
	@Column(name="id")
	private String id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,  CascadeType.REFRESH})
	@JoinColumn(name = "id_city")
	@JsonIgnoreProperties("parkingFacilities")
	private City city;
	
	@Column(name="capacity")
	private int capacity;
	
	@Column(name="available_capacity")
	private int availableCapacity;
	
	@Column(name="parking_type")
	@JsonIgnore
	private String parkingType;

	public ParkingFacility() {
		super();
	}

	public ParkingFacility(String id, String name, City city, int capacity, String parkingType) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.capacity = capacity;
		this.parkingType = parkingType;
	}

	public int getIntId() {
		return intId;
	}

	public void setIntId(int intId) {
		this.intId = intId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getAvailableCapacity() {
		return availableCapacity;
	}

	public void setAvailableCapacity(int availableCapacity) {
		this.availableCapacity = availableCapacity;
	}

	public String getParkingType() {
		return parkingType;
	}

	public void setParkingType(String parkingType) {
		this.parkingType = parkingType;
	}	
	
	
}
