package com.claimspension.service;



import com.claimspension.entity.PensionDetail;
import com.claimspension.entity.PensionerDetails;


public interface ClaimService {

	public PensionDetail processPension(long aadharno,PensionerDetails p);
}
