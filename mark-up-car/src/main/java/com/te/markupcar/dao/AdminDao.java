package com.te.markupcar.dao;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.te.markupcar.dto.Admin;
@Repository
public interface AdminDao extends CrudRepository<Admin,Integer> {
	public Admin findById(int id);

	public Admin findByUsername(String username);
	
	

}
