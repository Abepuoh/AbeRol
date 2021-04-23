package com.proyecto.AbeRol.Model;

import java.time.LocalDateTime;
import java.util.List;

public class RolDAO extends Rol {
	
	private final static String GETROLBYID = "SELECT id FROM Rol WHERE rol=";	
//	private final static String GETDESCRIP = 
//	private final static String GETDATE =
//	private final static String GETPLAYERS =	
			
			
			
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
