package com.proyecto.AbeRol.Model;

/**
 * Clase donde guardaremos los datos de los personajes para no
 * hacer que un player tenga muchos datos y sea un clase tan ámplia.
 * @author Abepuoh
 *
 */
public class Character {
	
	private String name; //nombre
	private int level; // nivel
	private int strenght; // fuerza
	private int dexterity; // destreza
	private int intelligence; //inteligencia
	private String information; //información
	private double height; //altura
	private double weight; //peso

	public Character(String name, int level, int strenght, int dexterity, int intelligence, String information,
			double height, double weight) {
		super();
		this.name = name;
		this.level = level;
		this.strenght = strenght;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.information = information;
		this.height = height;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getStrenght() {
		return strenght;
	}

	public void setStrenght(int strenght) {
		this.strenght = strenght;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	

}

