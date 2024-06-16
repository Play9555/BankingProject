package com.inchoise.creation.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inchoise.creation.dto.Accountcreationdto;
import com.inchoise.creation.exceptions.AccountAlreadyExistsException;
import com.inchoise.creation.mapper.AccountMapper;
import com.inchoise.creation.model.Accountcreation;
import com.inchoise.creation.repository.AccountRepository;

import jakarta.transaction.Transactional;

@Service
public class AccountService {

	@Autowired
	AccountRepository repo;

	@Transactional
	public Accountcreationdto createaccount(Accountcreationdto creation) throws AccountAlreadyExistsException {
		Accountcreation existingAccount = repo.findByGovtId(creation.getGovtId());
		if(existingAccount != null)
		{
			throw new AccountAlreadyExistsException("Account already exists for government ID: " + creation.getGovtId());
		
		}
		
		else
		{
			LocalDateTime now = LocalDateTime.now();
	        creation.setCreatedDate(now);
	        creation.setUpdatedDate(now);
			Accountcreation acc = repo.save(AccountMapper.Instance.mapAccountcreationdtoToAccountcreation(creation));
			return AccountMapper.Instance.mapAccountcreationToAccountcreationdto(acc);
		}
	}

	public ResponseEntity<Accountcreationdto> fetchaccountdetails(long id) {
		// TODO Auto-generated method stub
		Optional<Accountcreation>  acc = repo.findById(id);
		if(acc.isPresent()) {
		return new ResponseEntity<>(AccountMapper.Instance.mapAccountcreationToAccountcreationdto(acc.get()),HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
				
				//(AccountMapper.Instance.mapAccountcreationToAccountcreationdto(acc));
	}

}
