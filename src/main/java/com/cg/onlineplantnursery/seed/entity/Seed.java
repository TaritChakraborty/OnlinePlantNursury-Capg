package com.cg.onlineplantnursery.seed.entity;

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
public class Seed {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer seedId;
	
	@Column(name = "cname")
	private String commonName;
	
	@Column(name = "bloomtime")
	private String bloomTime;
	
	private String watering;
	
	@Column(name = "difficulty")
	private String difficultyLevel;
	
	private String temparature;
	
	@Column(name = "type")
	private String typeOfSeeds;
	
	@Column(name = "description")
	private String seedsDescription;
	
	@Column(name = "stock")
	private int seedsStock;
	
	@Column(name = "scost")
	private double seedsCost;
	
	@Column(name = "quantity")
	private int seedsPerPacket;
	
	@Transient
	private int seedQuantity;
	
}
