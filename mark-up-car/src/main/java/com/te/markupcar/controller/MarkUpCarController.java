package com.te.markupcar.controller;

import java.util.List;

import javax.persistence.RollbackException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.markupcar.dto.Admin;
import com.te.markupcar.dto.AdminResponse;
import com.te.markupcar.dto.Car;
import com.te.markupcar.jwt.JwtUtil;
import com.te.markupcar.model.AuthenticationRequest;
import com.te.markupcar.model.AuthenticationResponse;
import com.te.markupcar.service.AdminService;

@RestController
@CrossOrigin(origins = "*")
public class MarkUpCarController {
	
	
	@Autowired
	private AdminService service;
	@Autowired
	private AuthenticationManager authenticateManager;
	@Autowired
	private JwtUtil jwtTokenUtil;

	@PostMapping("/adminRegister")
	public ResponseEntity<?> createRegistration(@RequestBody Admin admin) {
		Admin createRegistration = service.createRegistration(admin);
		if (createRegistration != null) {
			authenticateManager.authenticate(new UsernamePasswordAuthenticationToken(createRegistration.getUsername(),
					createRegistration.getPassword()));

			UserDetails userDetails = service.loadUserByUsername(createRegistration.getUsername());
			String jwtToken = jwtTokenUtil.generateToken(userDetails);

			return ResponseEntity.ok(new AdminResponse(false, "Success", jwtToken));
		} else {
			return ResponseEntity.ok(new AdminResponse(true, "Username Already Exists ", null));
		}
		

	}

	
	@PostMapping("/adminloginauthenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			
			 authenticateManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
			
			
		} catch (BadCredentialsException e) {
			
			return ResponseEntity.ok(new AuthenticationResponse(true, "Login Failed, Invalid user",null));

		}
		System.out.println("test");
		final UserDetails userDetails = service.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(false, "Successfull Login", jwt));

	}

	@GetMapping(path = { "/allcar" })
	public ResponseEntity<?> cardetails() {
		try {
			List<Car> carDetails = service.CarDetails();
			return new ResponseEntity<List<Car>>(carDetails, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Something Went Wrong !", HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@PostMapping(path = "/Car")
	public ResponseEntity<?> addDetails(@RequestBody Car car) {
		try {
			service.addCar(car);
			return new ResponseEntity<String>("Data is Inserted !", HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<String>("Something Went Wrong !", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(path = "/Car/{carId}")
	public ResponseEntity<?> deleteDetails(@PathVariable int carId) {
		try {
			service.deleteCar(carId);
			return new ResponseEntity<String>("Car Details is Deleted", HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<String>("Something went Wrong ", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(path = "/Car/{carId}")
	public ResponseEntity<?> updateDetails(@PathVariable int carId, @RequestBody Car car) {
		try {
			service.updateCar(carId, car);
			return new ResponseEntity<String>("car Details Upadated", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Something Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
