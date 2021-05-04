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
				q.setInt(1, this.id);
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
		Master dummy = new Master();
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(EnumBBDD.GETBYEMAIL.getString());
				q.setString(1, this.name);
				// dummy.setName(q);
				q.setString(2, this.password);
				// dummy.setPassword(q);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dummy;

	}

	@Override
	public int deleteMaster(int id) {
		int result = 0;
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(EnumBBDD.DELETE.getString());
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
			if (rs.next()) {
				if (rs.getString("name").trim().length() > 0) {
					Master mainMaster = new Master();
					mainMaster.setName(rs.getString("name"));
					mainMaster.setPassword(rs.getString("password"));
					MasterDAO dummy = new MasterDAO(mainMaster);
					mainMaster = dummy;
					result = true;
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		return result;
	}

	@Override
	public boolean createAccount(String name, String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}