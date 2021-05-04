package com.proyecto.AbeRol.Model;

/**
 * Clase Player donde almacenaremos todos los datos de un persosnaje
 * 
 * @author Abepuoh
 *
 */
public class Player extends Character {

	private int id;
	private String classRol;
	private int age;
	private Rol contains;

	public Player(String name, int level, int strenght, int dexterity, int intelligence, String information,
			double height, double weight, int id, String classRol, int age, Rol contains) {
		super(name, level, strenght, dexterity, intelligence, information, height, weight);
		this.id = id;
		this.classRol = classRol;
		this.age = age;
		this.contains = contains;
	}

	public Player() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getClassRol() {
		return classRol;
	}

	public void setClassRol(String classRol) {
		this.classRol = classRol;
	}

	public Rol getContains() {
		return contains;
	}

	public void setContains(Rol contains) {
		this.contains = contains;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Player dummy = (Player) obj;
		if (id != dummy.id)
			return false;
		return true;
	}
}
