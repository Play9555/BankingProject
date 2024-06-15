package com.inchoise.creation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inchoise.creation.dto.Accountcreationdto;
import com.inchoise.creation.service.AccountService;

@RestController
@RequestMapping("/inchoise")
public class AccountController {
	
	@Autowired
	AccountService Accservice;
	
	@PostMapping("/createaccount")
	public ResponseEntity<Accountcreationdto> AccountCreation(@RequestBody Accountcreationdto creation) {
		Accountcreationdto Accountcreated = Accservice.createaccount(creation);
	
		return new ResponseEntity<>(Accountcreated,HttpStatus.CREATED);
	}
	
	

}
