package com.certified.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.certified.entity.Certification;

@Service
public interface CertificationService {

	public  Certification registerCertification(Certification certification) ;

	public List<Certification> getAllCertifications();

	public Certification updateCertification(Certification certification);

	public String deleteCertification(Certification certification);
    
	public List<Certification> sortingBasedOnCost();

	public Certification addCertification(Certification certification);

	public List<Certification> viewAllCertifications();

	public List<Certification> findByeId(Integer cId);
	

    
}
