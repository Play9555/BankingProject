package com.inchoise.creation.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Accountcreation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long UserId;
	private long AccountNumber;
	private String AccountType;
	private String AccountStatus;
	private Boolean AccountInd;

}
