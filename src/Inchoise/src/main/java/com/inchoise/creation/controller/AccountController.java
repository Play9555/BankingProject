package com.inchoise.creation.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inchoise.creation.dto.Accountcreationdto;
import com.inchoise.creation.exceptions.AccountAlreadyExistsException;
import com.inchoise.creation.service.AccountService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/inchoise")
public class AccountController {
	
	@Autowired
	AccountService Accservice;
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@PostMapping("/createaccount")
	public ResponseEntity<Accountcreationdto> AccountCreation(@RequestBody Accountcreationdto creation) throws AccountAlreadyExistsException {
		logger.info("Account creation started");
		Accountcreationdto Accountcreated = Accservice.createaccount(creation);
		logger.info("Account creation completed"+Accountcreated);
	
		return new ResponseEntity<>(Accountcreated,HttpStatus.CREATED);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Accountcreationdto> GetAccountDetails(@PathVariable long id){
		return  Accservice.fetchaccountdetails(id);
	}

}
