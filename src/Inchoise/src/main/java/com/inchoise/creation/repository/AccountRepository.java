package com.inchoise.creation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inchoise.creation.model.Accountcreation;


@Repository
public interface AccountRepository extends JpaRepository<Accountcreation, Long>{

	Accountcreation findByGovtId(String govtId);
}