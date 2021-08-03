package com.cg.onlineplantnursery.seed.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineplantnursery.seed.entity.Seed;

@Repository
public interface ISeedRepository extends JpaRepository<Seed, Integer>{
	Optional<Seed> findByCommonNameIgnoreCase(String commonName);

	List<Seed> findAllByTypeOfSeeds(String typeOfSeed);

}
