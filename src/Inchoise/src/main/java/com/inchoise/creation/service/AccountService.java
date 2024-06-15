package com.inchoise.creation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inchoise.creation.dto.Accountcreationdto;
import com.inchoise.creation.exceptions.AccountAlreadyExistsException;
import com.inchoise.creation.mapper.AccountMapper;
import com.inchoise.creation.model.Accountcreation;
import com.inchoise.creation.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository repo;

	public Accountcreationdto createaccount(Accountcreationdto creation) throws AccountAlreadyExistsException {
		Accountcreation existingAccount = repo.findByGovtId(creation.getGovtId());
		if(existingAccount != null)
		{
			throw new AccountAlreadyExistsException("Account already exists for government ID: " + creation.getGovtId());
		
		}
		
		else
		{
			Accountcreation acc = repo.save(AccountMapper.Instance.mapAccountcreationdtoToAccountcreation(creation));
			return AccountMapper.Instance.mapAccountcreationToAccountcreationdto(acc);	
		}
	}

}
