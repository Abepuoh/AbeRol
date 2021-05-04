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
			
			
	public RolDAO(String name, List<Player> players, LocalDateTime startdate,
			String description, int id) {
		super(name, players, startdate, description, id);
	}
	public RolDAO(int id) {
		super();
	}
	public RolDAO() {
		super();
	}
	
	public List<Player> getPlayer() {
		
		if (contains == null) {
			
			contains = RolDAO.searchByName(this.name);
		}
		return contains;
	}
	
	public static List<Player> searchByName(String nombre) {
		List<Player> result = new ArrayList<Player>();
		Connection con = xmlConnection.getConectionInfo();
		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(EnumBBDD.SELECTMASTER.getSelect());
				q.setString(1, "%" + nombre + "%");
				ResultSet rs = q.executeQuery();
				while (rs.next()) {
					// es que hay al menos un resultado
					Player a = new Player();
					a.setId(rs.getInt("id"));
					a.setName(rs.getString("name"));
					a.setDescription(rs.getString("description"));
					a.setPassive(rs.getInt("passive"));
					result.add(a);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}
}
