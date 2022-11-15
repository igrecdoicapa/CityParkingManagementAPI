package com.example.CityParkingManagementAPI.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="city")
public class City {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="int_id")
	@JsonIgnore
	private int intId;
	
	@Column(name="id")
	private String id;
	
	
	@Column(name="name")
	private String name;
	
	@Column(name="code")
	private String code;
	
	@OneToMany
	@JoinColumn(name = "id_city")
	private List<ParkingFacility> parkingFacilities;
	
	public City() {
		super();
	}
	
	

	public City(String id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<ParkingFacility> getParkingFacilities() {
		return parkingFacilities;
	}

	public void setParkingFacilities(List<ParkingFacility> parkingFacilities) {
		this.parkingFacilities = parkingFacilities;
	}

	
	
	
	
}
