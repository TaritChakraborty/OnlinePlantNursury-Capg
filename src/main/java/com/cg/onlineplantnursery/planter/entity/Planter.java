package com.cg.onlineplantnursery.planter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Planter {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer planterId;
	
	@Column(name = "height")
	private float planterheight;
	
	@Column(name = "capacity")
	private int planterCapacity;
	
	@Column(name = "drinage")
	private int drinageHoles;
	
	@Column(name = "pcolor")
	private String planterColor;
	
	@Column(name = "pshape")
	private String planterShape;

	@Column(name = "stock")
	private int planterStock;
	
	@Column(name = "cost")
	private double planterCost;	
	
	@Transient
	private int planterQuantity;

}
