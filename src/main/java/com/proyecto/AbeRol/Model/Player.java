package com.proyecto.AbeRol.Model;

/**
 * Clase Player donde almacenaremos todos los datos de un persosnaje
 * 
 * @author Abepuoh
 *
 */
public class Player extends Character {

	protected int id;
	protected String classRol;
	protected int age;
	protected Rol contains;

	public Player(int id,String name, int level, int strength, int dexerity, int intelligence, String information,
			int height, int weight, String classRol, int age, Rol contains) {
		super(name, level, strength, dexerity, intelligence, information, height, weight);
		this.id = id;
		this.classRol = classRol;
		this.age = age;
		this.contains = contains;
	}

	public Player() {
		this(-1,"Unknown",-1,-1,-1,-1,"Unknown",-1,-1,"Unknown",-1,new Rol());
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
