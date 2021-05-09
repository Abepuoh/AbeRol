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


public class MasterDAO extends Master {

	public MasterDAO(int id, String name, String email, String password,List<Rol> rol) {
		super(id, name, email, password, rol);
	}

	public MasterDAO(String name, String email, String password) {
		super(name, email, password);
	}

	public MasterDAO(String name, String password) {
		super(name, password);
	}

	public MasterDAO() {
		super();
	}

	public MasterDAO(Master aux) {
		this.id = aux.id;
		this.name = aux.name;
		this.email = aux.email;
		this.password = aux.email;
		this.rol = aux.rol;
	}

	public MasterDAO(int id) {
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement query = con.prepareStatement(EnumBBDD.GETMASTERBYID.getString());
				query.setInt(1, id);
				ResultSet rs = query.executeQuery();
				while (rs.next()) {
					this.name = rs.getString("Name");
					this.email = rs.getString("Email");
					this.password = rs.getString("Password");
				}
				this.rol = MasterDAO.getRolByMaster(this.id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public MasterDAO(String email) {
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement query = con.prepareStatement(EnumBBDD.GETMASTERBYEMAIL.getString());
				query.setString(1, email);
				ResultSet rs = query.executeQuery();
				while (rs.next()) {
					this.id = rs.getInt("id");
					this.name = rs.getString("Name");
					this.password = rs.getString("Password");
				}
				RolDAO u = new RolDAO();
				// this.rol=u.getRolByMaster(this.id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int SaveMaster() {
		int saveResult = 0;
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(EnumBBDD.INSERTUPDATEMASTER.getString());
				q.setString(1, this.name);
				q.setString(2, this.email);
				q.setString(3, this.password);
				q.setString(4, this.name);
				q.setString(5, this.email);
				q.setString(6, this.password);
				saveResult = q.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return saveResult;
	}

	public int deleteMaster(String name) {
		int deleteMasterResult = 0;
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(EnumBBDD.DELETEMASTER.getString());
				q.setString(1, name);
				deleteMasterResult = q.executeUpdate();
				this.id = -1;
				this.name = "Unknown";
				this.email = "Unknown@Email";
				this.password = "UnknownPassword";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return deleteMasterResult;
	}

	public boolean logIn(String name, String password) {
		boolean logResult = false;
		try {
			Connection con = ConnectionDB.getConexion();
			PreparedStatement q = con.prepareStatement(EnumBBDD.LOGINMENU.getString());
			q.setString(1, name);
			q.setString(2, password);
			ResultSet rs = q.executeQuery();
			if (!rs.next()) {
				logResult = false;
			} else {
				logResult = true;
			}
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return logResult;
	}

	public List<Rol> getMyRols(int id) {
		
		if(rol==null) {
			rol=MasterDAO.getRolByMaster(this.id);
		}
		System.out.println(rol);
		return rol;
	}

	public static List<Rol> getRolByMaster(int id) {
		List<Rol> rolList = FXCollections.observableArrayList();
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
}