package com.cg.onlineplantnursery.plant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineplantnursery.plant.entity.Plant;

@Repository
public interface IPlantRepository extends JpaRepository<Plant, Integer>{
	Plant findByCommonNameIgnoreCase(String commonName);

	List<Plant> findByTypeOfPlantIgnoreCase(String typeOfPlant);
	
	//@Query("SELECT p.plantId,p.plantsStock FROM Plant p, Orders o where p.plant_fk = o.bookingOrderId")
	//List<Object[]> getInfromationByBooking();

}
