package com.cristian.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cristian.lookify.models.Cancion;
import com.cristian.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	
	private final LookifyRepository lookifyRepo;
	
	public LookifyService(LookifyRepository lookifyRepo) {
		this.lookifyRepo = lookifyRepo;
	}

	public List<Cancion> allSongs(){
		return lookifyRepo.findAll();
	}
	
	public Cancion createSong(Cancion song) {
		return lookifyRepo.save(song);
	}
	
	public Cancion infoSong(Long id) {
		Optional<Cancion> op = lookifyRepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}else {
			return null;
		}
	}
	
	public void deleteSong(Long id) {
		lookifyRepo.deleteById(id);
	}
	
	public List<Cancion> allSongArtist(String artista){
		return lookifyRepo.findByArtistaContaining(artista);
	}
	
}
