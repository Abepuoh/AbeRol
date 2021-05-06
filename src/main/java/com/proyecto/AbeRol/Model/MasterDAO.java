package com.proyecto.AbeRol.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.proyecto.AbeRol.Interfaces.IMasterDAO;
import com.proyecto.AbeRol.UIUtils.*;

public class MasterDAO extends Master implements IMasterDAO {

	public static MasterDAO MMaster;

	public MasterDAO(int id, String name, String email, String password, List<Rol> rol) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.rol = rol;
	}

	public MasterDAO(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public MasterDAO(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public MasterDAO(String email) {
		this.email = email;
	}

	public MasterDAO() {
		this(-1, "Unknown", "Unknown@Email", "UnknownPassword", null);
	}

	public MasterDAO(Master a) {
		this.id = a.id;
		this.name = a.name;
		this.email = a.email;
		this.password = a.email;
	}

	public MasterDAO(int id) {
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement query = con.prepareStatement(EnumBBDD.GETBYID.getString());
				query.setInt(1, id);
				ResultSet rs = query.executeQuery();
				while (rs.next()) {
					this.id = rs.getInt("ID");
					this.name = rs.getString("Name");
					this.password = rs.getString("Password");
					this.email = rs.getString("Password");
					// this.rol=rs.getString("rol");
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
				PreparedStatement q = con.prepareStatement(EnumBBDD.INSERTUPDATE.getString());
				q.setString(2, this.name);
				q.setString(3, this.password);
				q.setString(4, this.email);
				// q.setInt(5, this.rol);
				result = q.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Master getMasterByEmail(String email) {
		Master mainMaster = new Master();
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(EnumBBDD.GETBYEMAIL.getString());
				q.setString(1, email);
				ResultSet rs = q.executeQuery();
				if(!rs.next()) {
				mainMaster.setName(rs.getString("name"));
				mainMaster.setPassword(rs.getString("password"));
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
				this.rol = null;
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