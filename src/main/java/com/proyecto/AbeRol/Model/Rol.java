package com.proyecto.AbeRol.Model;

import java.util.List;

/**
 * Clase que usaremos para guardar los 
 * roles con los datos del rol y jugadores
 * @author Abepuoh
 *
 */
public class Rol {
	
	protected int id;
	protected String name;
	protected String description;
	protected Master masterRol;
	protected List<Player> contains;
	
	public Rol(int id,String name,String description, Master masterRol, List<Player> contains) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.masterRol = masterRol;
		this.contains = contains;
	}

	public Rol(int id) {
		this.id = id;
	}

	public Rol() {
		this(-1,"UnknownRol","UnknownDesc",new Master(),null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Player> getPlayer() {
		return contains;
	}

	public void setPlayer(List<Player> player) {
		this.contains = player;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol other = (Rol) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
