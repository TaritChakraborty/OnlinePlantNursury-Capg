package com.cg.onlineplantnursery.admin;

import java.lang.reflect.Field;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineplantnursery.customer.entity.Customer;
import com.cg.onlineplantnursery.customer.service.CustomerService;
import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.plant.service.PlantService;
import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.planter.service.PlanterService;
import com.cg.onlineplantnursery.seed.entity.Seed;
import com.cg.onlineplantnursery.seed.service.SeedService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	private int validAdmin = 0; //flag variable
	@Autowired
	private CustomerService customerservice;
	
	@Autowired
	private PlantService plantservice;
	
	@Autowired
	private SeedService seedservice;
	
	@Autowired
	private PlanterService planterservice;
	
	@Autowired
	private AdminService adminservice;
	
	/*..........................For Admin..................................*/
	
	@GetMapping("/login/{username}/{password}")
	public ResponseEntity<?> loginAdmin(@PathVariable("username") String username, @PathVariable("password") String password) {
		if(adminservice.validateAdmin(username, password) == true) {
			validAdmin = 1;
			Admin admin = adminservice.viewByAdminUserName(username, password).get();
			String welcome = "Welcome \n........................\n";
			return ResponseEntity.ok(welcome + "Id : " + admin.getAdminId() + "\nUsername : " + admin.getAdminUsername());
		} else
			return ResponseEntity.ok("Invalid credentials");
	}
	
	@PostMapping("/admin")
	public Admin addAdmin(@Validated @RequestBody Admin admin) {
		return adminservice.addAdmin(admin);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<?> logout(){
		if(validAdmin == 1) {
			validAdmin = 0;
			return ResponseEntity.ok("Logged out...");		
		}else
			return ResponseEntity.ok("Not Logged In");
	}
	
	/*..........................For Customer.............................*/
	
	@GetMapping("/customer")
	public ResponseEntity<?> viewAllCustomers(){
		if(validAdmin == 1) {
			return ResponseEntity.ok(customerservice.viewAllCustomers());
		}else
		return ResponseEntity.ok("Not Logged In");
	}
		
	@PatchMapping("/customer/{id}")
	public ResponseEntity<?> updateCustomerById(@PathVariable("id") Integer customerId,
			@Validated @RequestBody Map<Object, Object> fields) {
		if(validAdmin == 1) {
			Customer customer = customerservice.viewCustomer(customerId);
			if(customer != null) {
		    	  fields.forEach((key,value) -> {
		    		  Field field = ReflectionUtils.findField(Customer.class, (String)key);
		    		  field.setAccessible(true);
		    		  ReflectionUtils.setField(field, customer, value);
		    	  });	    	  
		    }return ResponseEntity.ok(customerservice.updateCustomer(customer));
		}else
		return ResponseEntity.ok("Not Logged In");
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") Integer customerId) {
		if(validAdmin == 1) {
			return ResponseEntity.ok(customerservice.deleteCustomer(customerId));
		}else
		return ResponseEntity.ok("Not Logged In");
	}
	
	/*..........................For Plants................................*/
	
	@PostMapping("/plant")
	public ResponseEntity<?> saveOrder(@RequestBody Plant plant) {
		if(validAdmin == 1) {
			return ResponseEntity.ok(plantservice.addPlant(plant));
		}else
		return ResponseEntity.ok("Not Logged In");
	}

	@PatchMapping("/plant/{id}")
	public ResponseEntity<?> updatePlantById(@PathVariable("id") Integer plantId,
			@Validated @RequestBody Map<Object, Object> fields) {
		if(validAdmin == 1) {
			Plant plant = plantservice.viewPlant(plantId);
			if(plant != null) {
		    	  fields.forEach((key,value) -> {
		    		  Field field = ReflectionUtils.findField(Plant.class, (String)key);
		    		  field.setAccessible(true);
		    		  ReflectionUtils.setField(field, plant, value);
		    	  });	    	  
		    }return ResponseEntity.ok(plantservice.updatePlant(plant));
		}else
		return ResponseEntity.ok("Not Logged In");
	}
	 
	@DeleteMapping("/plant/{id}")
	public ResponseEntity<?> deletePlant(@PathVariable("id") Integer id) {
		if(validAdmin == 1) {
			return ResponseEntity.ok(plantservice.deletePlant(id));
		}else
		return ResponseEntity.ok("Not Logged In");
	}

	@GetMapping("/plant")
	public ResponseEntity<?> fetchAllOrders() {
		if(validAdmin == 1) {
			return ResponseEntity.ok(plantservice.viewAllPlants());
		}else
		return ResponseEntity.ok("Not Logged In");
	}
	
	/*........................For Planters................................*/
	
	@PostMapping("/planter")
	public ResponseEntity<?> addPlanter(@RequestBody Planter planter) {
		if(validAdmin == 1) {
			return ResponseEntity.ok(planterservice.addPlanter(planter));
		}else
		return ResponseEntity.ok("Not Logged In");
	}

	@GetMapping("/planter")
	public ResponseEntity<?> viewAllPlanters() {
		if(validAdmin == 1) {
			return ResponseEntity.ok(planterservice.viewAllPlanters());
		}else
		return ResponseEntity.ok("Not Logged In");
	}
	
	@DeleteMapping("/planter/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Integer planterId) {
		if(validAdmin == 1) {
			return ResponseEntity.ok(planterservice.deletePlanter(planterId));
		}else
		return ResponseEntity.ok("Not Logged In");
	}
    /*
	@PutMapping("/planter")
	public ResponseEntity<?> updatePlanter(@RequestBody Planter planter) {
		if(validAdmin == 1) {
			return ResponseEntity.ok(planterservice.updatePlanter(planter));
		}else
		return ResponseEntity.ok("Not Logged In");
	}
	*/
	@PatchMapping("/planter/{id}")
	public ResponseEntity<?> updatePlanterById(@PathVariable("id") Integer planterId,
			@Validated @RequestBody Map<Object, Object> fields) {
		if(validAdmin == 1) {
			Planter planter = planterservice.viewPlanter(planterId);
			if(planter != null) {
		    	  fields.forEach((key,value) -> {
		    		  Field field = ReflectionUtils.findField(Planter.class, (String)key);
		    		  field.setAccessible(true);
		    		  ReflectionUtils.setField(field, planter, value);
		    	  });	    	  
		    }return ResponseEntity.ok(planterservice.updatePlanter(planter));
		}else
		return ResponseEntity.ok("Not Logged In");
	}
	
	/*........................For Seeds...................................*/
	
	@GetMapping("/seed")
	public ResponseEntity<?> viewAllSeeds() {
		if(validAdmin == 1) {			
			return ResponseEntity.ok(seedservice.viewAllSeeds());
		}else
		return ResponseEntity.ok("Not Logged In");
	}
	
	@PostMapping("/seed")
	public ResponseEntity<?> addSeed(@RequestBody Seed seed) {
		if(validAdmin == 1) {
			return ResponseEntity.ok(seedservice.addSeed(seed));
		}else
		return ResponseEntity.ok("Not Logged In");
	}
    /*
	@PutMapping("/seed")
	public ResponseEntity<?> updateSeed(@RequestBody Seed seed) {
		if(validAdmin == 1) {
			return ResponseEntity.ok(seedservice.updateSeed(seed));
		}else
		return ResponseEntity.ok("Not Logged In");
	}
	*/
	
	@PatchMapping("/seed/{id}")
	public ResponseEntity<?> updateSeedById(@PathVariable("id") Integer seedId,
			@Validated @RequestBody Map<Object, Object> fields) {
		if(validAdmin == 1) {
			Seed seed = seedservice.viewSeed(seedId);
			if(seed != null) {
		    	  fields.forEach((key,value) -> {
		    		  Field field = ReflectionUtils.findField(Seed.class, (String)key);
		    		  field.setAccessible(true);
		    		  ReflectionUtils.setField(field, seed, value);		    		  
		    	  });	    	  
		    }return ResponseEntity.ok(seedservice.updateSeed(seed));
		}else
		return ResponseEntity.ok("Not Logged In");
	}

	@DeleteMapping("/seed/{id}")
	public ResponseEntity<?> deleteSeed(@PathVariable Integer id) {
		if(validAdmin == 1) {
			return ResponseEntity.ok(seedservice.deleteSeed(id));
		}else
		return ResponseEntity.ok("Not Logged In");
	}

}
