package com.inchoise.creation.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Accountcreation {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long UserId;
	private long accountNumber;
	private String accountType;
	private String accountStatus;
	private Boolean accountInd;
	//under standing custom query procedure jpa try to match the method with entity it is adviced to follow camel case notation
	//in some case you will end up the errors
	private String govtId;

}
