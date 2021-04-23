package com.proyecto.AbeRol.Model;

/**
 * Clase Player donde almacenaremos todos los datos de un persosnaje
 * @author Abepuoh
 *
 */
public class Player extends Character {

	private static int ID_COUNTER = 1;
	private int id;
	private Class auxClass;
	private int age;

	public Player(String name, int level, int force, int dexterity, int intelligence,String information,
			double height, double weight, String gender, int id, Class auxClass, int age) {
		super(name, level, force, dexterity, intelligence, information, height, weight,
				gender);
		this.auxClass = auxClass;
		this.age = age;
		
		this.id = ID_COUNTER;
		ID_COUNTER++;
	}
	
	public static int getID_COUNTER() {
		return ID_COUNTER;
	}

	public static void setID_COUNTER(int iD_COUNTER) {
		ID_COUNTER = iD_COUNTER;
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

