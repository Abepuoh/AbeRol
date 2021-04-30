package com.proyecto.AbeRol.Model;

import java.util.List;
/**
 * Clase Master la cual sera primordial para el desarrollo de la aplicación.
 * @author Abepuoh
 *
 */
public class Master {
	
	protected int id;
	protected String name;
	protected String email;
	protected String password;
	protected List<Rol> rol;

	public Master(int id, String name, String email, String password, List<Rol> rol) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.rol = rol;
	}
	
	public Master(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Master(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public Master(int id) {
		super();
		this.id = id;
	}

	public Master(String email) {
		super();
		this.email = email;
	}
	public Master() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Rol> getRol() {
		return rol;
	}

	public void setRol(List<Rol> rol) {
		this.rol = rol;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Master other = (Master) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
