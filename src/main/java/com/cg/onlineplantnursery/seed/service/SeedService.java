package com.cg.onlineplantnursery.seed.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlineplantnursery.exceptions.SeedCommonNameNotFoundException;
import com.cg.onlineplantnursery.exceptions.SeedIdNotFoundException;
import com.cg.onlineplantnursery.seed.entity.Seed;
import com.cg.onlineplantnursery.seed.repository.ISeedRepository;

@Service
public class SeedService implements ISeedService{

	@Autowired
	private ISeedRepository repo ;
		
	@Override
	public List<Seed> viewAllSeeds() {
		
		return repo.findAll();
	}
	
	@Override
	public Seed viewSeed(Integer seedId)  {
		
		return repo.findById(seedId)
				.orElseThrow(() -> new SeedIdNotFoundException("Seed by id" 
											+ seedId + " was not found"));
	}	
	
	@Override
	public List<Seed> viewAllSeeds(String typeOfSeed) {
		
		return repo.findAllByTypeOfSeeds(typeOfSeed);
	}
	

	@Override
	public Seed viewSeedByName(String commonName) {
		return repo.findByCommonNameIgnoreCase(commonName)				
				.orElseThrow(() -> new SeedCommonNameNotFoundException("Seed by id" 
				+ commonName + " was not found"));
	}
	
	@Override
	public Seed addSeed(Seed seed) {
		// TODO Auto-generated method stub
		return repo.save(seed);
	}

	@Override
	public Seed updateSeed(Seed seed) {
		return repo.save(seed);
	}

	@Override
	public Seed deleteSeed(Integer seedId) {
		Seed seed = repo.findById(seedId).get();
		repo.deleteById(seedId);
		return seed;
	}

}
