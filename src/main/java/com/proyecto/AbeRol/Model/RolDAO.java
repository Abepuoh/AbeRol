package com.proyecto.AbeRol.Model;

import java.time.LocalDateTime;
import java.util.List;

public class RolDAO extends Rol {		
			
			
	public RolDAO(String name, List<Player> jugadores, LocalDateTime fechaInicio,
			String descripcion, int id) {
		super(name, jugadores, fechaInicio, descripcion, id);
	}
	public RolDAO(int id) {
		super();
	}
	public RolDAO() {
		super();
	}
	
	
}
