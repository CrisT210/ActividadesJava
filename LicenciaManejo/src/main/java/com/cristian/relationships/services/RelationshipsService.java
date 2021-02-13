package com.cristian.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cristian.relationships.models.License;
import com.cristian.relationships.models.Person;
import com.cristian.relationships.repositories.LicenseRepository;
import com.cristian.relationships.repositories.PersonRepository;

@Service
public class RelationshipsService {

	private final PersonRepository relRepo;
	private final LicenseRepository licenseRep;
	int nroLicense = 0;
	
	public RelationshipsService(PersonRepository relRepo, LicenseRepository licenseRep) {
		this.relRepo = relRepo;
		this.licenseRep = licenseRep;
	}
	
	public List<Person> allPersons(){
		return relRepo.findAll();
	}
	
	public Person crearPerson(Person person) {
		return relRepo.save(person);
	}
	
	public License crearLicense(License license) {
		nroLicense++;
		String format = String.format("%06d", nroLicense);
		license.setNumber(format);
		return licenseRep.save(license);
	}
	
	public Person infoPerson(Long id) {
		Optional<Person> op = relRepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
		
	}
}
