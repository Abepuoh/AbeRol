package com.proyecto.AbeRol.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.AbeRol.UIUtils.EnumBBDD;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RolDAO extends Rol {

	public RolDAO(int id, String name, String description, Master masterRol, List<Player> players) {
		super(id, name, description, masterRol, players);

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
	
	public RolDAO(int id) {
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement query = con.prepareStatement(EnumBBDD.GETROLBYNAME.getString());
				query.setInt(1, id);
				ResultSet rs = query.executeQuery();
				while (rs.next()) {
					this.id = rs.getInt("id");
					this.name = rs.getString("name");
					this.description = rs.getString("description");
					this.masterRol = new MasterDAO(rs.getInt("id_Master"));
				}
				this.players = PlayerDAO.getPlayerByRol(this.id);
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

	public List<Player> getMyPlayers() {
		if (this.players == null) {
			this.players = PlayerDAO.getPlayerByRol(this.id);
		}
		return this.players;
	}

	public static ObservableList<Rol> getRolByMaster(int id) {
		ObservableList<Rol> rolList = FXCollections.observableArrayList();
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(EnumBBDD.GETROLBYMASTER.getString());
				q.setInt(1, id);
				ResultSet rs = q.executeQuery();
				while (rs.next()) {
					// cada row
					Rol auxR = new Rol();
					auxR.setId(rs.getInt("id"));
					auxR.setName(rs.getString("name"));
					auxR.setDescription(rs.getString("description"));
					rolList.add(auxR);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rolList;
	}

	@Override
	public String toString() {
		return "RolDAO [id=" + id + ", name=" + name + ", description=" + description + ", masterRol=" + masterRol
				+ ", players=" + players + "]";
	}

}
