package com.proyecto.AbeRol.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.proyecto.AbeRol.Interfaces.IMasterDAO;
import com.proyecto.AbeRol.UIUtils.*;
import com.reproductor.proyectofinal.model.User;
import com.reproductor.proyectofinal.model.UserDAO;
import com.reproductor.proyectofinal.utils.ConnectionUtil;

public class MasterDAO extends Master {

	public MasterDAO(int id, String name, String surname, String password, List<Rol> rol) {
		super(id, name, surname, password, rol);

	}

	public MasterDAO() {
		super();
	}

	public MasterDAO(int id) {
		super(id);
	}

	public MasterDAO(String name, String password) {
		super(name, password);
	}

	public MasterDAO(String email) {
		super(email);
	}

	public static boolean Login(String userName, String userPassword) {
		boolean result = false;
		try {
			java.sql.Connection conn; // = Connection.getConnection();
			PreparedStatement ps = conn.prepareStatement(EnumBBDD.LOGINMENU);
			ps.setString(1, userName);
			ps.setString(2, userPassword);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getString("name").trim().length() > 0) {
					Master dummy = new Master();
					dummy.setName(rs.getString("name"));
					dummy.setPassword(rs.getString("password"));
					MasterDAO dummyDAO = new MasterDAO(/** falta meterle el user */
					);
					dummy = dummyDAO;
					result = true;
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex);
			Logger.getLogger(MasterDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return result;
	}

	public static boolean deleteUser() {
		boolean result = false;
		if (MainUser.getIDUsuario() > 0) {
			try {
				java.sql.Connection csql = ConnectionUtil.getConnection();
				String q = "DELETE FROM Usuario WHERE IDUsuario = " + MainUser.getIDUsuario();
				PreparedStatement ps = csql.prepareStatement(q);
				ps.executeUpdate();
				result = true;
			} catch (SQLException ex) {
				Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return result;
	}
	 public int save() {
	        int result = 0;
	        try {
	        java.sql.Connection csql = ConnectionUtil.getConnection();
	        if (this.IDUsuario > 0) {
	            //UPDATE
	            String q = "UPDATE Usuario SET Nombre = ?, Password = ?, Pais = ?, estiloFav = ?, artistaFav = ? WHERE IDUsuario = ?";
	            PreparedStatement ps = csql.prepareStatement(q);
	            ps.setString(1, Nombre);
	            ps.setString(2, Password);
	            ps.setString(3, Pais);
	            ps.setString(4, estiloFavorito);
	            ps.setString(5, artistaFav);
	            ps.setInt(6, MainUser.IDUsuario);
	            
	            result = ps.executeUpdate();
	        } else {
	            //INSERT
	            String q = "INSERT INTO Usuario(IDUsuario, Nombre, Password, Pais, estiloFav, artistaFav) VALUES(NULL,?,?,?,?,?)";
	            PreparedStatement ps = csql.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);
	            ps.setString(1, Nombre);
	            ps.setString(2, Password);
	            ps.setString(3, Pais);
	            ps.setString(4, estiloFavorito);
	            ps.setString(5, artistaFav);
	            result = ps.executeUpdate();
	            System.out.println(result);
	            try(ResultSet generatedKeys = ps.getGeneratedKeys()){
	                if(generatedKeys.next()){
	                    result = generatedKeys.getInt(1);
	                }
	            }
	            this.IDUsuario = result;
	        }
	        
	    } catch (SQLException ex){
	        Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }

	        return result;
	    }
}