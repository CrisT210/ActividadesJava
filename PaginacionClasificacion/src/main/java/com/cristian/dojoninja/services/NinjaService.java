package com.cristian.dojoninja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cristian.dojoninja.models.Ninja;
import com.cristian.dojoninja.repositories.NinjaRepository;

@Service
@Transactional
public class NinjaService {
	
	@Autowired 
    NinjaRepository ninjaRepo;
    //la variable estática establece el número de ninjas que queremos mostrar por página.
    private static final int PAGE_SIZE = 5;
    public Page<Ninja> ninjasPerPage(int pageNumber) {
        // Obtener todas las páginas de ninjas y clasificarlas en orden ascendente por apellido.
        PageRequest pageRequest = PageRequest.of(pageNumber, PAGE_SIZE, Sort.by("apellido").ascending());
        Page<Ninja> ninjas = ninjaRepo.findAll(pageRequest);
        return ninjas;
    }

}
