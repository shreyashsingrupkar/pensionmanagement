package com.claimspension.serviceimpl;


import org.springframework.stereotype.Service;

import com.claimspension.entity.PensionAmount;
import com.claimspension.entity.PensionDetail;
import com.claimspension.entity.PensionerDetails;
import com.claimspension.service.ClaimService;
@Service
public class ClaimServiceImpl implements ClaimService {

	@Override
	public PensionDetail processPension(long aadharno,PensionerDetails p) {
			
		
		PensionDetail pd=new PensionDetail();
		double salaryearned=p.salaryearned;
		double allowances=p.allowances;
		
		
		double selfpension=((salaryearned+allowances)*80)/100;
		double familypension=((salaryearned+allowances)*50)/100;
    
     
     PensionAmount pa=new PensionAmount();
     pa.setFamilypension(familypension);
     pa.setSelfpension(selfpension);
    
     pd.setPensionamount(pa);;
     String banktype1=p.banktype;
     String pub="public";
     if(banktype1.matches(pub)) {
    	 pd.setBankservicecharge(500.0);
     }else {
    	 pd.setBankservicecharge(550.0);
     }
     
		
		return pd ;
	}

}
