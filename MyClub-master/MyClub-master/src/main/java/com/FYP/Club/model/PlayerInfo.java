package com.FYP.Club.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class PlayerInfo {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String position;
	private int age;
	private int height;
	private int weight;
	private String bio;
	
	
	
	public PlayerInfo() {
		super();
	}
	




	public PlayerInfo(Long id, String position, int age, int height,
			int weight, String bio) {
		super();
		this.id = id;
		this.position = position;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.bio = bio;
	}





	public int getAge() {
		return age;
	}





	public void setAge(int age) {
		this.age = age;
	}





	public int getHeight() {
		return height;
	}





	public void setHeight(int height) {
		this.height = height;
	}





	public int getWeight() {
		return weight;
	}





	public void setWeight(int weight) {
		this.weight = weight;
	}





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	
	
	


}
