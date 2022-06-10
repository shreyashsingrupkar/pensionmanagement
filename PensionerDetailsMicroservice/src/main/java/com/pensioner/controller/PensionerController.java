package com.pensioner.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pensioner.entity.Pensioner;
import com.pensioner.service.PensionerService;

@RestController

public class PensionerController {

	@Autowired
	PensionerService pensionerService;
	
	@PostMapping(value="/addpensioner")
	ResponseEntity<Pensioner>addPensionerDetails(@RequestBody Pensioner pensioner) {
		
		Pensioner p=pensionerService.addPensioner(pensioner);
		return new ResponseEntity<Pensioner>(p,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/PensionerDetailByAadhaar/{aadharno}" ,method = RequestMethod.GET)
	ResponseEntity<Optional<Pensioner>> getPensionerDetails(@PathVariable long aadharno){
		Optional<Pensioner> p=pensionerService.getPensioner(aadharno);
		return new ResponseEntity<Optional<Pensioner>> (p,HttpStatus.OK);
	}
}
