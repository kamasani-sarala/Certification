package com.certified.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.certified.entity.Certification;
import com.certified.repository.CertificationRepository;
import com.certified.service.CertificationService;


@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/certification")
public class CertificationController {
	@Autowired
	CertificationService certificationService;
	
	@Autowired
	CertificationRepository certificationRepository;
	
	@GetMapping("/")
	public String defaultMessage() {
		return "Welcome to Certification Page";
	}
	//http://localhost:9000/certification/registerCertification
	@PostMapping("/registerCertification")
	public Certification addCertification(@RequestBody Certification certification)  {
		try {
			return certificationService.addCertification(certification);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return certification;
	}
	//http://localhost:8089/Certification/allCertification
	@GetMapping("/allCertificates")
	public List<Certification> viewAllcertifications(){
		return certificationService.viewAllCertifications();
	}
	
	//http://localhost:8089/Certification/updateCertification
	@PutMapping("/updateCertificate")
	public Certification updateCertification(@RequestBody Certification certification) {
		return certificationService.updateCertification(certification);
	}
	
	//http://localhost:8089/Certification/deleteCertification
	@DeleteMapping("/deleteCertification")
	public String deleteCertification(@RequestBody Certification certification)  {
		return certificationService.deleteCertification(certification);
	}
	//http://localhost:9000/certification/cId/3
	@GetMapping("/cId/{cId}")
	public ResponseEntity <List<Certification>> getById(@PathVariable int cId){
		List<Certification> listcertification= certificationRepository.findByeId(cId);
//		Certification c = certificationRepository.findById(eId).get();
//		
		return new ResponseEntity<>(listcertification,HttpStatus.OK);
	}
	
	
}


