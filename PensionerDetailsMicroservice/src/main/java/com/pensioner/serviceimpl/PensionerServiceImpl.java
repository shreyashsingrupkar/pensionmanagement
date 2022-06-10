package com.pensioner.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pensioner.entity.Pensioner;
import com.pensioner.repo.PensionerRepo;
import com.pensioner.service.PensionerService;
@Service
public class PensionerServiceImpl implements PensionerService{
	@Autowired
	PensionerRepo pensionerRepo;
	@Override
	public Pensioner addPensioner(Pensioner pensioner) {
		// TODO Auto-generated method stub
		Pensioner addPen=pensionerRepo.save(pensioner);
		return addPen;
	}

	@Override
	public Optional<Pensioner> getPensioner(long aadharno) {
		// TODO Auto-generated method stub
		Optional<Pensioner> p=pensionerRepo.findById(aadharno);
		return p;
	}

}
