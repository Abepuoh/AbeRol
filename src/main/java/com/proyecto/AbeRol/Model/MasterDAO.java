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

import pruebaDAO.utils.Conexion;


public class MasterDAO extends Master {
	
	private final static String LOGINMENU ="SELECT name,password FROM Master WHERE name LIKE ? and password LIKE ?";
	private final static String GETBYEMAIL = "SELECT name,email,password FROM autor WHERE email = ?"; 
	private final static String INSERTMASTER = "INSERT INTO master (name,email,password) VALUES (?,?,?)";
	private final static String SELECTMASTER = "SELECT name,email,password FROM Master";
	private final static String	DELETE = "DELETE FROM Master WHERE id=?";
	private final static String	UPDATEMASTER ="UPDATE Master SET name = ?, password = ?, email = ?, Rols = ?,  WHERE Id = ?";
	
	
	
	
	public static MasterDAO MMaster;

	public MasterDAO(int id, String name, String surname, String password, List<Rol> rol) {
		super(id, name, surname, password, rol);

	}

	public MasterDAO(String name, String password) {
		super(name, password);
	}

	public MasterDAO(String email) {
		super(email);
	}

	public MasterDAO() {
		super();
	}

	public MasterDAO(int id) {
		super(id);
	}

	public MasterDAO(Master a) {
		this.id = a.id;
		this.name = a.name;
		this.email = a.email;
		this.password = a.email;
	}

	public static boolean logIn(String userName, String userPassword) {
		boolean result = false;
		try {
			Connection conn = xmlConnection.getConexion();
			PreparedStatement ps = conn.prepareStatement(LOGINMENU);
			ps.setString(1, userName);
			ps.setString(2, userPassword);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getString("name").trim().length() > 0) {
					Master dummy = new Master();
					dummy.setName(rs.getString("name"));
					dummy.setPassword(rs.getString("password"));
					MasterDAO dummyDAO = new MasterDAO(dummy);
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

	public static boolean deleteUser(String id) {
		boolean rs = false;
	    Connection con = xmlConnection.getConexion();

	    if (con != null) {
	      try {
	        PreparedStatement q = con.prepareStatement(DELETE);
	        q.setString(1,id);
	        rs = q.executeUpdate();
	        this.name = "U";
	        this.nombre = "";
	        this.edad = -1;
	      } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }
	    }
	    return rs;
	  }

	public int save() {
	        int result = 0;
	        try {
		        Connection csql = xmlConnection.getConexion();  
		        if (this.id > 0) {
		            //UPDATE
		            PreparedStatement q = csql.prepareStatement(UPDATEMASTER);
		            q.setString(1, name);
		            q.setString(2, email);
		            q.setString(3, password);
		            q.setString(result, DELETE);
		            q.setInt(6, MainUser.IDUsuario);
		            
		            result = q.executeUpdate();
		        } else {
		            //INSERT
		            String q = "INSERT INTO Usuario(IDUsuario, Nombre, Password, Pais, estiloFav, artistaFav) VALUES(NULL,?,?,?,?,?)";
		            PreparedStatement ps = csql.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);
		            ps.setString(1, name);
		            ps.setString(2, password);
		            ps.setString(3, email);
		            ps.setLString(4, );
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
		        Logger.getLogger(Master.class.getName()).log(Level.SEVERE, null, ex);
		    }

	        return result;
	    }
}