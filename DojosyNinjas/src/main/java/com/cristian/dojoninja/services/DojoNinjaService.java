package com.cristian.dojoninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cristian.dojoninja.models.Dojo;
import com.cristian.dojoninja.models.Ninja;
import com.cristian.dojoninja.repositories.DojoRepository;
import com.cristian.dojoninja.repositories.NinjaRepository;

@Service
public class DojoNinjaService {
	
	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	
	public DojoNinjaService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	
	public Dojo crearDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public List<Dojo> listaDojos(){
		return dojoRepo.findAll();
	}
	
	public Ninja crearNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public Dojo infoDojo(Long id) {
		Optional<Dojo> op = dojoRepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
	}
}
