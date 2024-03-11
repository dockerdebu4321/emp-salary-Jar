package com.ey.practice.SpringBootPractice.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="vehicleinformation")
public class VehicleEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int vid;
	
	@Column(name = "brand")
	private String vehicleBrand;
	
	@Column(name = "evehicle_evolved")
	private boolean evehicle_evolved;
	
	@Column(name = "name")
	private String vehicleName;
	
	@Column(name = "type")
	private String vehicleType;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "have_regd_number")
	private boolean have_regd_number;

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public boolean isEvehicle_evolved() {
		return evehicle_evolved;
	}

	public void setEvehicle_evolved(boolean evehicle_evolved) {
		this.evehicle_evolved = evehicle_evolved;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isHave_regd_number() {
		return have_regd_number;
	}

	public void setHave_regd_number(boolean have_regd_number) {
		this.have_regd_number = have_regd_number;
	}
	

}
