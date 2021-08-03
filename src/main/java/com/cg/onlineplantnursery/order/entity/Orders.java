package com.cg.onlineplantnursery.order.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.cg.onlineplantnursery.customer.entity.Customer;
import com.cg.onlineplantnursery.plant.entity.Plant;
import com.cg.onlineplantnursery.planter.entity.Planter;
import com.cg.onlineplantnursery.seed.entity.Seed;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer bookingOrderId;
	
	@JsonBackReference
	@ManyToOne(targetEntity = Customer.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_fk")
	private Customer customer;

	private String orderDate;
	private String transactionMode;	
	private int quantity;
	private double totalCost;
	
	private Integer planterQuantity;
	private Integer plantQuantity;
	private Integer seedQuantity;
	
	@OneToMany(targetEntity = Planter.class, cascade = CascadeType.ALL) 
	@JoinColumn(name = "planter_fk", referencedColumnName = "bookingOrderId")
	private List<Planter> planters;
	
	@OneToMany(targetEntity = Plant.class, cascade = CascadeType.ALL) 
	@JoinColumn(name = "plant_fk", referencedColumnName = "bookingOrderId")
	private List<Plant> plant;
	
	@OneToMany(targetEntity = Seed.class, cascade = CascadeType.ALL) 
	@JoinColumn(name = "seed_fk", referencedColumnName = "bookingOrderId")
	private List<Seed> seed;
	
}
