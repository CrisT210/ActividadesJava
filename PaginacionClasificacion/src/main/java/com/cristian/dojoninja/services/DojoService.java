package com.cristian.dojoninja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cristian.dojoninja.repositories.DojoRepository;

@Service
@Transactional
public class DojoService {
	
	@Autowired
	DojoRepository dojoRepo;
	private static final int PAGE_SIZE = 5;
	public Page<Object[]> dojoAndNinjaPerPage(int pageNumber){
		PageRequest pageRequest = PageRequest.of(pageNumber, PAGE_SIZE, Sort.by("nombre").ascending());
		Page<Object[]> dojos = dojoRepo.joinDojosAndNinjas2(pageRequest);
		return dojos;
	}

}
