package com.cristian.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cristian.countries.models.City;
import com.cristian.countries.models.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {
	
	@Query("SELECT c, l FROM Country c JOIN c.languages l WHERE l.language = 'Slovene' ORDER BY l.percentage DESC")
	List<Object[]> allCountriesSlovene();
	
	@Query("SELECT c, COUNT(t) FROM Country c JOIN c.cities t GROUP BY c ORDER BY COUNT(t) DESC")
	List<Object[]> countCities();
	
	@Query("SELECT t FROM Country c JOIN c.cities t WHERE c.name = 'Mexico' AND t.population > 500000 ORDER BY t.population DESC")
	List<City> populationMexico();
	
	@Query("SELECT c, l FROM Country c JOIN c.languages l WHERE l.percentage > 89 ORDER BY l.percentage DESC")
	List<Object[]> languagesWorld();
	
	@Query("SELECT c FROM Country c WHERE c.surface_area < 501 AND c.population > 100000")
	List<Country> areaPopulationWorld();
	
	@Query("SELECT c FROM Country c WHERE c.government_form = 'Constitutional Monarchy' AND c.surface_area > 200 AND c.life_expectancy > 75")
	List<Country> monarchy();
	
	@Query("SELECT c, t FROM Country c JOIN c.cities t WHERE c.name = 'Argentina' AND t.population > 500000")
	List<Object[]> citiesArgentina();
	
	@Query("SELECT c.region, COUNT(c) FROM Country c GROUP BY c.region ORDER BY COUNT(c) DESC")
	List<Object[]> continent();
}
