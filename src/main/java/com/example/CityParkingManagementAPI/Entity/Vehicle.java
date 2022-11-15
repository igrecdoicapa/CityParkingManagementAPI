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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="vehicle")
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="int_id")
	@JsonIgnore
	private int intId;
	
	@Column(name="id")
	private String id;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,  CascadeType.REFRESH})
	@JoinColumn(name = "id_city")
	private City city;
	
	@Column(name="is_parked")
	private boolean isParked;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,  CascadeType.REFRESH})
	@JoinColumn(name = "id_parking_facility")
	@JsonIgnore
	private ParkingFacility parkingFacility;
	
	@Transient
	private String parkingFacilityId;
	
	@Column(name="vehicle_type")
	@JsonIgnore
	private String vehicleType;

	public Vehicle() {
		super();
	}

	public Vehicle(String id, City city, String parkingFacilityId, String vehicleType) {
		super();
		this.id = id;
		this.city = city;
		this.parkingFacilityId = parkingFacilityId;
		this.vehicleType = vehicleType;
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public boolean isParked() {
		return isParked;
	}

	public void setParked(boolean isParked) {
		this.isParked = isParked;
	}

	public ParkingFacility getParkingFacility() {
		return parkingFacility;
	}

	public void setParkingFacility(ParkingFacility parkingFacility) {
		this.parkingFacility = parkingFacility;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getParkingFacilityId() {
		return parkingFacilityId;
	}

	public void setParkingFacilityId(String parkingFacilityId) {
		this.parkingFacilityId = parkingFacilityId;
	}
	
	
	
}
