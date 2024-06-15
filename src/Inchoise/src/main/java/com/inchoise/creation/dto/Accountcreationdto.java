package com.inchoise.creation.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Accountcreationdto {

	private long userId;
	private long accountNumber;
	private String accountType;
	private String accountStatus;
	private Boolean accountInd;
	private String govtId;
}
