package com.proyecto.AbeRol.Model;


import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase que usaremos para guardar los 
 * roles con los datos del rol y jugadores
 * @author Abepuoh
 *
 */
public class Rol {
	
	protected String name;
	protected List<Player> contains;
	protected LocalDateTime startdate;
	protected String description;
	protected int id;

	public Rol(String name, List<Player> player, LocalDateTime startdate, String description, int id) {
		super();
		this.name = name;
		this.contains = player;
		this.startdate = startdate;
		this.description = description;
		this.id = id;
	}

	public Rol(int id) {
		super();
		this.id = id;
	}

	public Rol() {
		super();
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

	public LocalDateTime getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDateTime startdate) {
		this.startdate = startdate;
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

	@Override
	public String toString() {
		return "Rol =" + name + ",contiene: Jugadores=" + contains + "\n -FechaInicio=" + startdate
				+ "\n -Descripcion=" + description + " -Id=" + id;
	}

}
