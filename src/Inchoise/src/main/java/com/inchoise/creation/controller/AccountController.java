package com.inchoise.creation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inchoise.creation.model.Accountcreation;
import com.inchoise.creation.service.AccountService;

@RestController
@RequestMapping("/inchoise")
public class AccountController {
	
	@Autowired
	AccountService Accservice;
	
	@PostMapping("/createaccount")
	public ResponseEntity<String> AccountCreation(@RequestBody Accountcreation creation) {
		String response = Accservice.createaccount(creation);
	
		return ResponseEntity.ok(response);
	}
	
	

}
