package com.cg.onlineplantnursury.plant;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.plant.service.PlantService;

@DataJpaTest
public class PlantControllerTest {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private PlantService plantService;

	private Plant plant;

	@BeforeEach
	void setup() {
		@SuppressWarnings("unused")
		Plant plant = Plant.builder().plantId(101).plantHeight(0).commonName("Cashewnuts").bloomTime("Winter")
				.medicinalOrCulinaryUse("Medicinal").difficultyLevel("Moderate").temparature("Cold")
				.typeOfPlant("Fruit Producing").plantDescription(null).plantCost(300.00).build();

	}

	@Test(expected = NullPointerException.class)
	public void updatePlant() throws Exception {
		Plant ipplant = Plant.builder().plantId(101).plantHeight(0).commonName("Cashewnuts").bloomTime("Winter")
				.medicinalOrCulinaryUse("Medicinal").difficultyLevel("Moderate").temparature("Cold")
				.typeOfPlant("Fruit Producing").plantDescription(null).plantCost(300.00).build();
		
		Mockito.when(plantService.updatePlant(ipplant)).thenReturn(plant);
		
		mvc.perform(MockMvcRequestBuilders.put("/updatePlant").contentType(MediaType.APPLICATION_JSON).content("{\n" + "}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	@Test(expected = NullPointerException.class)
	public void fetchSeedById() throws Exception {
		Mockito.when(plantService.viewPlant(0)).thenReturn(plant);

		mvc.perform(MockMvcRequestBuilders.get("/order/{id}").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.commonName").value(plant.getCommonName()));
	}
}

