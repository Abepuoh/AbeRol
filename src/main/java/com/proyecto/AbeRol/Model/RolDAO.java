package com.proyecto.AbeRol.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.proyecto.AbeRol.Interfaces.IRolDAO;
import com.proyecto.AbeRol.UIUtils.ConnectionDB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RolDAO extends Rol implements IRolDAO {
	
	private final static String GETROLBYID = "SELECT id,name,description,id_Master FROM Rol WHERE id=?";
	private final static String GETROLBYNAME = "SELECT id, name, description, id_master FROM rol WHERE name =?";
	private final static String INTERTUPDATEROL = "INSERT INTO Rol (name,description) VALUES(?,?) ON DUPLICATE KEY UPDATE name= ?, description= ?";
	private final static String UPDATEROL = "UPDATE Rol SET name= ?,description=? Where id = ?";
	private final static String DELETEROL = "DELETE FROM Rol WHERE name = ?";
	private final static String GETROLBYMASTER = "SELECT id,name,description FROM Rol WHERE id_master = ?";
	
	public RolDAO(int id, String name, String description, Master masterRol, ObservableList<Player> players) {
		super(id, name, description, masterRol, players);

	}

	public RolDAO(String name, String description, Master masterRol) {
		super(name, description, masterRol);

	}

	public RolDAO(String name, String description) {
		super(name, description);
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
				PreparedStatement query = con.prepareStatement(GETROLBYID);
				query.setInt(1, id);
				ResultSet rs = query.executeQuery();
				while (rs.next()) {
					this.id = rs.getInt("id");
					this.name = rs.getString("name");
					this.description = rs.getString("description");
					this.masterRol = new MasterDAO(rs.getInt("id_Master"));
					this.players = PlayerDAO.getPlayerByRol(this.id);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public RolDAO(String name) {
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement query = con.prepareStatement(GETROLBYNAME);
				query.setString(1, name);
				ResultSet rs = query.executeQuery();
				while (rs.next()) {
					this.id = rs.getInt("id");
					this.name = rs.getString("name");
					this.description = rs.getString("description");
					this.masterRol = new MasterDAO(rs.getInt("id_Master"));
					this.players = PlayerDAO.getPlayerByRol(this.id);
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
				PreparedStatement q = con.prepareStatement(INTERTUPDATEROL);
				q.setString(1, this.name);
				q.setString(2, this.description);
				q.setString(3, this.name);
				q.setString(4, this.description);
				saveResult = q.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return saveResult;
	}

	/**
	 * method I will use to update an existing user via the user id
	 * 
	 * @param id of the rol
	 * @return an existing user updated
	 */
	public int updateRol(int id) {
		int saveResult = 0;
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(UPDATEROL);
				q.setString(1, this.name);
				q.setString(2, this.description);
				q.setInt(3, id);
				saveResult = q.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return saveResult;
	}

	/**
	 * Delete a Rol starting from the id
	 * 
	 * @param name identify of the Rol
	 * @return true if successfully removed
	 **/
	public static int deleteRol(String name) {
		int deleteMasterResult = 0;
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(DELETEROL);
				q.setString(1, name);
				deleteMasterResult = q.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return deleteMasterResult;
	}

	/**
	 * method that returns the rol of a master
	 * 
	 * @param id of the master
	 * @return an observable list of rols
	 */
	public static ObservableList<Rol> getRolByMaster(int id) {
		ObservableList<Rol> rolList = FXCollections.observableArrayList();
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(GETROLBYMASTER);
				q.setInt(1, id);
				ResultSet rs = q.executeQuery();
				while (rs.next()) {
					Rol auxR = new Rol();
					auxR.setId(rs.getInt("id"));
					auxR.setName(rs.getString("name"));
					auxR.setDescription(rs.getString("description"));
					rolList.add(auxR);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rolList;
	}

	///////////////////// UPDATE /////////////////////

	private final static String CREATE = "INSERT INTO Rol (name,description,id_master) VALUES(?,?,?) ON DUPLICATE KEY UPDATE"
			+ " name= ?, description= ?,id_master= ?";

	/**
	 * new method that allows the user to save a new role game
	 * 
	 * @return the new role game
	 */
	public int createRol() {
		int saveResult = 0;
		Connection con = ConnectionDB.getConexion();
		if (this.masterRol == null) {
			this.masterRol = new Master();
		}
		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(CREATE);
				q.setString(1, this.name);
				q.setString(2, this.description);
				q.setInt(3, this.masterRol.id);
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

}
