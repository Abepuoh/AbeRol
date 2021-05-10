package com.proyecto.AbeRol.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
	protected ObservableList<Player> players;
	
	public Rol(int id,String name,String description, Master masterRol, ObservableList<Player> players) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.masterRol = masterRol;
		this.players = players;
	}
	
	public Rol(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Rol(int id) {
		this.id = id;
	}

	public Rol() {
		this(999,"UnknownRol","UnknownDesc",new Master(),FXCollections.observableArrayList());
	}

	public Master getMasterRol() {
		return masterRol;
	}

	public void setMasterRol(Master masterRol) {
		this.masterRol = masterRol;
	}

	public void setPlayers(ObservableList<Player> players) {
		this.players = players;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ObservableList<Player> getPlayer() {
		return players;
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
		if (name != other.name)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  name;
	}

}
