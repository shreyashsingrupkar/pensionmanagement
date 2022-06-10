package com.claimspension.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.claimspension.entity.PensionDetail;
import com.claimspension.entity.PensionerDetails;
import com.claimspension.repo.AuthClient;
import com.claimspension.serviceimpl.ClaimServiceImpl;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController

public class ProcessPensionController{
	private static final Logger log = LoggerFactory.getLogger(ProcessPensionController.class);
	
	
	
	@Autowired
	private AuthClient authClient;
	
	
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ClaimServiceImpl claimServiceImpl;
	@RequestMapping("/ProcessPension/{aadharno}")
	@ApiOperation(notes = "Process the pension and returns pension ammount", value = "Process the pension")
	public ResponseEntity<PensionDetail> getPensionDetail(@PathVariable(value="aadharno") int aadharno,@RequestHeader(value = "Authorization", required = true) String requestTokenHeader)
	{
		
		
			log.debug("In process pension controller");
			log.debug("Token Passed: "+requestTokenHeader );
			
			try {
				
				if(authClient.authorizeTheRequest(requestTokenHeader).isValid()==true) 
				{
					log.debug("authorization success");
					log.info("Token valid :"+authClient.authorizeTheRequest(requestTokenHeader).isValid());
				 
					
					  PensionerDetails p= restTemplate.getForObject("http://localhost:9002/PensionerDetailByAadhaar/"+aadharno,PensionerDetails.class);
		   
					  PensionDetail pd=claimServiceImpl.processPension(aadharno, p);
					  
					  return new ResponseEntity<PensionDetail>(pd, HttpStatus.OK);

				}
				
			}catch(Exception e){
				 return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

			}
			return null;
			
				
			
			
			}
			
	
	
	
}
