package com.cristian.countries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cristian.countries.models.City;
import com.cristian.countries.models.Country;
import com.cristian.countries.repositories.CountryRepository;

@Service
public class ApiService {

	private final CountryRepository cRepo;
	
	public ApiService(CountryRepository cRepo) {
		this.cRepo = cRepo;
	}
	
	public List<Object[]> listaEsloveno(){
		return cRepo.allCountriesSlovene();
	}
	
	public List<Object[]> totalCiudades(){
		return cRepo.countCities();
	}
	
	public List<City> poblacionMexico(){
		return cRepo.populationMexico();
	}
	
	public List<Object[]> languagesWorld(){
		return cRepo.languagesWorld();
	}
	
	public List<Country> areaPopulationWorld(){
		return cRepo.areaPopulationWorld();
	}
	
	public List<Country> monarchy(){
		return cRepo.monarchy();
	}
	
	public List<Object[]> citiesArg(){
		return cRepo.citiesArgentina();
	}
	
	public List<Object[]> countCountries(){
		return cRepo.continent();
	}
	
}
