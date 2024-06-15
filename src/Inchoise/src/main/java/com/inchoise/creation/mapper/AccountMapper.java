package com.inchoise.creation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.inchoise.creation.dto.Accountcreationdto;
import com.inchoise.creation.model.Accountcreation;

@Mapper
public interface AccountMapper {

AccountMapper Instance = Mappers.getMapper(AccountMapper.class)	;

Accountcreation mapAccountcreationdtoToAccountcreation(Accountcreationdto accountcreationdto);
Accountcreationdto mapAccountcreationToAccountcreationdto(Accountcreation accountcreation);
}
