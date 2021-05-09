package com.proyecto.AbeRol.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.proyecto.AbeRol.UIUtils.EnumBBDD;

import javafx.collections.FXCollections;

public class RolDAO extends Rol {

	public RolDAO(int id, String name, String description, Master masterRol, List<Player> players) {
		super(id, name, description, masterRol, players);

	}

	public RolDAO(int id) {
		super(id);

	}

	public RolDAO() {
		super();

	}

	public RolDAO(Rol aux) {
		this.id = aux.id;
		this.name = aux.name;
		this.description = aux.description;
		this.masterRol = aux.masterRol;
		this.players = aux.players;
	}

	public RolDAO(String name) {
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement query = con.prepareStatement(EnumBBDD.GETROLBYNAME.getString());
				query.setString(1, name);
				ResultSet rs = query.executeQuery();
				while (rs.next()) {
					this.id = rs.getInt("id");
					this.name = rs.getString("name");
					this.description = rs.getString("description");
					this.masterRol = new MasterDAO(rs.getInt("id_Master"));
					this.players=PlayerDAO.getPlayerByRol(this.id);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int saveRol() {
		int saveResult = 0;
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(EnumBBDD.INTERTUPDATEROL.getString());
				q.setString(1, this.name);
				q.setString(2, this.description);
				q.setInt(3, this.masterRol != null ? this.masterRol.id : -1);
				q.setString(4, this.name);
				q.setString(5, this.description);
				q.setInt(6, this.masterRol.id);
				saveResult = q.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return saveResult;
	}

	public int deleteRol(String name) {
		int deleteMasterResult = 0;
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(EnumBBDD.DELETEROL.getString());
				q.setString(1, name);
				deleteMasterResult = q.executeUpdate();
				this.id = -1;
				this.name = "Unknown";
				this.description = "UnknownDescription";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return deleteMasterResult;
	}
//
//	public static Rol getRolByPlayer(int id) {
//		Rol result = new Rol();
//		Connection con = ConnectionDB.getConexion();
//		if (con != null) {
//			try {
//				PreparedStatement q = con.prepareStatement(SELECTAUTORBYISBN);
//				q.setString(1, isbn);
//				ResultSet rs = q.executeQuery();
//				while (rs.next()) {
//					result.setDni(rs.getString("dni"));
//					result.setNombre(rs.getString("nombre"));
//					result.setEdad(rs.getInt("edad"));
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//		return result;
//	}
}
