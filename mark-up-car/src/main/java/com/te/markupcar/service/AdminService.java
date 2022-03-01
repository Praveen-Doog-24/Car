package com.te.markupcar.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.te.markupcar.dao.AdminDao;
import com.te.markupcar.dao.MarkUpCarDao;
import com.te.markupcar.dto.Admin;
import com.te.markupcar.dto.Car;
import com.te.markupcar.dto.MyAdmin;




@Service
public class AdminService implements UserDetailsService{
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private MarkUpCarDao carDao;
	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin AdminName = adminDao.findByUsername(username);
		if (AdminName!=null) {
			
			return new MyAdmin(AdminName);
		}
		throw new UsernameNotFoundException("Admin is Not Found! ");
	}
	
	
	public Admin createRegistration(Admin admin) {
		return adminDao.save(admin);
	}
	
	
	
	public List<Car> CarDetails() {
		return  (List<Car>) carDao.findAll();
	}
	
	
	public Car addCar(Car car) {
		
		return carDao.save(car);
		
	}
	
	public void deleteCar(int carId) {
		 Car findByCarId = carDao.findByCarId(carId);
		 
			 carDao.delete(findByCarId);
			 
		}
	
	public Car updateCar(int carId, Car car) {
	  
		Car details = carDao.findByCarId(carId);
		return carDao.save(details);
	
	
	}
	
	
	
	
	}
	


