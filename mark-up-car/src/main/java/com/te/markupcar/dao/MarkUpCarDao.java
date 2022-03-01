package com.te.markupcar.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.te.markupcar.dto.Car;

@Repository
public interface MarkUpCarDao extends CrudRepository<Car,Integer> {
	
	
	public Car findByCarId(int carId);
	
	
}
