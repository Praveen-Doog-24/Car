package com.te.markupcar.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;
import org.springframework.data.annotation.Reference;



@Entity
public class Car {
	@Id() 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "carId")
	private int carId;
	
	@Column(name = "Name")
	private String carName;
	
	@Column(name = "Company")
	private String carCompany;
	
	@Column(name = "Fuel_Type")
	private String carFuelType;
	
	@Column(name = "PowerSteering")
	private Boolean carPowerSteering;
	
	@Column(name = "Break_System")
	private String carBreakSystem;
	
	@Column(name = "Showroom_Price")
	private double carShowroomPrice;
	
	@Column(name = "Onroad_Price")
	private double carOnroadPrice;
	
	@Column(name = "Image_URL")
	private String carImageURL;
	
	@Column(name = "Mileage")
	private double carMileage;
	
	@Column(name = "Seating_Capacity")
	private int carSeatingCapacity;
	
	@Column(name = "Engine_Capacity")
	private int carEngineCapacity;
	
	@Column(name = "Gear_Type")
	private String carGearType;
	
	@ManyToOne()
	@JoinColumn(referencedColumnName = "Id")
	private Admin admin;
	
	
	
	
	
	public int getId() {
		return carId;
	}
	public void setId(int id) {
		this.carId = id;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarCompany() {
		return carCompany;
	}
	public void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}
	public String getCarFuelType() {
		return carFuelType;
	}
	public void setCarFuelType(String carFuelType) {
		this.carFuelType = carFuelType;
	}
	public Boolean getCarPowerSteering() {
		return carPowerSteering;
	}
	public void setCarPowerSteering(Boolean carPowerSteering) {
		this.carPowerSteering = carPowerSteering;
	}
	public String getCarBreakSystem() {
		return carBreakSystem;
	}
	public void setCarBreakSystem(String carBreakSystem) {
		this.carBreakSystem = carBreakSystem;
	}
	public double getCarShowroomPrice() {
		return carShowroomPrice;
	}
	public void setCarShowroomPrice(double carShowroomPrice) {
		this.carShowroomPrice = carShowroomPrice;
	}
	public double getCarOnroadPrice() {
		return carOnroadPrice;
	}
	public void setCarOnroadPrice(double carOnroadPrice) {
		this.carOnroadPrice = carOnroadPrice;
	}
	public String getCarImageURL() {
		return carImageURL;
	}
	public void setCarImageURL(String carImageURL) {
		this.carImageURL = carImageURL;
	}
	public double getCarMileage() {
		return carMileage;
	}
	public void setCarMileage(double carMileage) {
		this.carMileage = carMileage;
	}
	public int getCarSeatingCapacity() {
		return carSeatingCapacity;
	}
	public void setCarSeatingCapacity(int carSeatingCapacity) {
		this.carSeatingCapacity = carSeatingCapacity;
	}
	public int getCarEngineCapacity() {
		return carEngineCapacity;
	}
	public void setCarEngineCapacity(int carEngineCapacity) {
		this.carEngineCapacity = carEngineCapacity;
	}
	public String getCarGearType() {
		return carGearType;
	}
	public void setCarGearType(String carGearType) {
		this.carGearType = carGearType;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	

}
