package com.proyecto.AbeRol.Model;

/**
 * Clase Player donde almacenaremos todos los datos de un persosnaje
 * @author Abepuoh
 *
 */
public class Player extends Character {

	private int id;
	private Class auxClass;
	private int age;
	private Rol contains;

	public Player(String name, int level, int strenght, int dexterity, int intelligence, String information,
			double height, double weight, int id, Class auxClass, int age, Rol contains) {
		super(name, level, strenght, dexterity, intelligence, information, height, weight);
		this.id = id;
		this.auxClass = auxClass;
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

	public Class getAuxClass() {
		return auxClass;
	}

	public void setAuxClass(Class auxClass) {
		this.auxClass = auxClass;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

