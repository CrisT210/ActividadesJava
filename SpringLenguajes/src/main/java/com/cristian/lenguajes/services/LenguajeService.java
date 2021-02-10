package com.cristian.lenguajes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cristian.lenguajes.models.Lenguaje;
import com.cristian.lenguajes.repositories.LenguajeRepository;

@Service
public class LenguajeService {

	private final LenguajeRepository lengRepo;
	
	public LenguajeService(LenguajeRepository lengRepo) {
		this.lengRepo = lengRepo;
	}
	
	public List<Lenguaje> allLenguajes(){
		return lengRepo.findAll();
	}
	
	public Lenguaje crearLeng(Lenguaje leng) {
		return lengRepo.save(leng);
	}
	
	public Lenguaje infoLeng(Long id) {
		Optional<Lenguaje> opLeng = lengRepo.findById(id);
        if(opLeng.isPresent()) {
            return opLeng.get();
        } else {
            return null;
        }
	}
        
    public void borrarLeng(Long id) {
    	lengRepo.deleteById(id);
    }
    
    public Lenguaje actualizarLeng(Long id, String nombre, String creador, String version) {
    	
    	Lenguaje leng = infoLeng(id);
    	
    	leng.setNombre(nombre);
    	leng.setCreador(creador);
    	leng.setVersion(version);
    	
    	return lengRepo.save(leng);
    }
    
    
}
