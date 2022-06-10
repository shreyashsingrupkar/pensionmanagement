package com.pensioner.service;

import java.util.Optional;

import com.pensioner.entity.Pensioner;

public interface PensionerService {

	Pensioner addPensioner(Pensioner pensioner);
	
	Optional<Pensioner> getPensioner(long aadharno);

}
