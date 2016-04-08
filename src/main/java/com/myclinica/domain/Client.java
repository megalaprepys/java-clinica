package com.myclinica.domain;

import java.util.ArrayList;
import java.util.List;

public class Client {
	
	private String name;
	private int id;
	private Animal animal;
	private List<Animal> animals = new ArrayList<Animal>();
	
	protected Client(int id, String name) {
		this.setId(id);
		this.setName(name);				
	}
	
	protected void setId(int id) {
		this.id = id;
	}
	
	protected int getId() {
		return this.id;
	}
	
	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;		
	}
	
	
	protected void addAnimal(Animal animal) {
		animals.add(animal);		
	}
	
	protected Animal getAnimal(int id) {
		return animals.get(id);
	}
	
	protected int getNumOfAnimals() {
		return animals.size();
	}
	
}
