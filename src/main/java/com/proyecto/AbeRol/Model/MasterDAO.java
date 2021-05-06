package com.proyecto.AbeRol.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.proyecto.AbeRol.Interfaces.IMasterDAO;
import com.proyecto.AbeRol.UIUtils.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MasterDAO extends Master implements IMasterDAO {

	public static MasterDAO MMaster;

	public MasterDAO(int id, String name, String email, String password, List<Rol> rol) {
		super(id, name, email, password, rol);
	}

	public MasterDAO(String name, String email, String password) {
		super(name,email,password);
	}

	public MasterDAO(String name, String password) {
		super(name,password);
	}

	public MasterDAO() {
		super();
	}

	public MasterDAO(Master aux) {
		this.id = aux.id;
		this.name = aux.name;
		this.email = aux.email;
		this.password = aux.email;
		this.rol=aux.rol;
	}
	
	public MasterDAO(int id) {
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement query = con.prepareStatement(EnumBBDD.GETMASTERBYID.getString());
				query.setInt(1, id);
				ResultSet rs = query.executeQuery();
				while (rs.next()) {
					this.id = rs.getInt("ID");
					this.name = rs.getString("Name");
					this.password = rs.getString("Password");
					this.email = rs.getString("Password");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int SaveMaster() {
		int result = 0;
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(EnumBBDD.INSERTUPDATEMASTER.getString());
				q.setString(1, this.name);
				q.setString(2, this.password);
				q.setString(3, this.email);
				q.setString(4, this.name);
				q.setString(5, this.password);
				q.setString(6, this.email);
				result = q.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public ObservableList<MasterDAO> getMasterByEmail(String email) {
		ObservableList<MasterDAO> mainMaster = FXCollections.observableArrayList();
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(EnumBBDD.GETMASTERBYEMAIL.getString());
				q.setString(1, email);
				ResultSet rs = q.executeQuery();
				if(!rs.next()) {
				String name = rs.getString("name");
				String password = rs.getString("password");
				MasterDAO dummy = new MasterDAO(name,password,email);
				mainMaster.add(dummy);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mainMaster;

	}

	@Override
	public int deleteMaster(int id) {
		int result = 0;
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(EnumBBDD.DELETEMASTER.getString());
				q.setInt(1, id);
				result = q.executeUpdate();
				this.id = -1;
				this.name = "Unknown";
				this.email = "Unknown@Email";
				this.password = "UnknownPassword";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public boolean logIn(String name, String password) {
		boolean result = false;
		try {
			Connection con = ConnectionDB.getConexion();
			PreparedStatement q = con.prepareStatement(EnumBBDD.LOGINMENU.getString());
			q.setString(1, name);
			q.setString(2, password);
			ResultSet rs = q.executeQuery();
			if (!rs.next()) {
					result = false;
				}else {
					result = true;
			}
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return result;
	}

	@Override
	public List<Rol> getRols() {

		if (rol == null) {
			
			// rol = MasterDAO.buscaLibrosPorAutor(this.dni);
		}
		return rol;
	}
}