package com.proyecto.AbeRol.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.AbeRol.UIUtils.EnumBBDD;
import com.proyecto.AbeRol.UIUtils.xmlConnection;

public class RolDAO extends Rol {	
	
	public static RolDAO MRol;
	
	public RolDAO(int id,String name,String description, Master masterRol, List<Player> contains) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.masterRol = masterRol;
		this.contains = contains;
	}

	public RolDAO(int id) {
		this.id = id;
	}

	public RolDAO() {
		this(-1,"UnknownRol","UnknownDesc",new Master(),new ArrayList<Player>());
	}		
	Connection con = ConnectionDB.getConexion();
	
	
}
