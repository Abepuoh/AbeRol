package com.proyecto.AbeRol.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

	public MasterDAO(String name) {
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement query = con.prepareStatement(EnumBBDD.GETMASTERBYNAME.getString());
				query.setString(1, name);
				ResultSet rs = query.executeQuery();
				while (rs.next()) {
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
		int saveResult = 0;
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
				saveResult = q.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return saveResult;
	}

	@Override
	public ObservableList<MasterDAO> getMasterByEmail(String email) {
		ObservableList<MasterDAO> getMasterResult = FXCollections.observableArrayList();
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(EnumBBDD.GETMASTERBYEMAIL.getString());
				q.setString(1, email);
				ResultSet rs = q.executeQuery();
				if (!rs.next()) {
					String name = rs.getString("name");
					String password = rs.getString("password");
					MasterDAO dummy = new MasterDAO(name, password, email);
					getMasterResult.add(dummy);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return getMasterResult;

	}

	@Override
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

	@Override
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

    public List<Rol> getRolsByMaster(String name) {
		List<Rol> rolList = new ArrayList<Rol>();
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(EnumBBDD.GETROLBYMASTERNAME.getString());
				q.setString(1,name);
				ResultSet rs = q.executeQuery();
				while(rs.next()) {
					Rol dummy = new Rol();
					dummy.setName(rs.getString("name"));
					dummy.setDescription(rs.getString("description"));
					rolList.add(dummy);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rolList;
	}

}