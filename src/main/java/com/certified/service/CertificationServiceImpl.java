package com.certified.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.certified.entity.Certification;
import com.certified.repository.CertificationRepository;

@Service
public class CertificationServiceImpl implements CertificationService{
	@Autowired
	CertificationRepository certificationRepository;

	@Override
	public List<Certification> getAllCertifications() {
		// TODO Auto-generated method stub
		 List<Certification> allCertification = new ArrayList<>();
		    // Add your logic to fetch exams and populate the allExams list
		    return allCertification;
	}

	@Override
	public Certification updateCertification(Certification certification) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCertification(Certification certification) {
		 // Assuming you have a list or database of certifications
	    List<Certification> certifications = getAllCertifications(); // Retrieve all certifications

	    // Check if the certification exists in the list/database
	    if (certifications.contains(certification)) {
	        // Delete the certification
	        certifications.remove(certification);
	        return "Certification deleted successfully.";
	    } else {
	        return "Certification not found.";
	    }
	}

	@Override
	public List<Certification> sortingBasedOnCost() {
		    List<Certification> certifications = getAllCertifications(); // Retrieve all certifications

		    // Sort certifications based on cost
		    certifications.sort(Comparator.comparingDouble(Certification::getCost));

		    return certifications;
		}

	

	@Override
	public Certification addCertification(Certification certification) {
		return certificationRepository.save(certification);
	}

	@Override
	public List<Certification> viewAllCertifications() {
		List<Certification> allCertifications = certificationRepository.findAll(); // Note : same as save
		return allCertifications;
		
	}
	@Override
   public List<Certification> findByeId(Integer cId) {
	return certificationRepository.findByeId(cId);

	 

	}

	@Override
	public Certification registerCertification(Certification certification) {
		return certificationRepository.save(certification);
	}

	
	

}