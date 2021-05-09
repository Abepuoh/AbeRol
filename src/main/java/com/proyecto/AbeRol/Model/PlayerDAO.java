package com.proyecto.AbeRol.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.AbeRol.UIUtils.EnumBBDD;

public class PlayerDAO extends Player  {
	
	public static PlayerDAO MPlayer;
	
	public PlayerDAO(int id, String name, int level, int strength, int dexerity, int intelligence, String information,
			int height, int weight, String classRol, int age, Rol contains) {
		super(id, name, level, strength, dexerity, intelligence, information, height, weight, classRol, age, contains);
		// TODO Auto-generated constructor stub
	}

	public PlayerDAO() {
		super();
	}
	public PlayerDAO(Player dummy) {
		this.id=dummy.id;
		this.classRol = dummy.classRol;
		this.age = dummy.age;
		this.contains = dummy.contains;
		this.name = dummy.name;
		this.level = dummy.level;
		this.strenght = dummy.strenght;
		this.dexerity = dummy.dexerity;
		this.intelligence = dummy.intelligence;
		this.information = dummy.information;
		this.height = dummy.height;
		this.weight = dummy.weight;	
	}
	
	public PlayerDAO(int id) {
		super();
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement q = con.prepareStatement(EnumBBDD.GETPLAYERBYID.getString());
				ResultSet rs = q.executeQuery();
				while(rs.next()) {
					this.id=rs.getInt("id");
					this.classRol = rs.getString("id");
					this.age = rs.getInt("id");
					this.contains = new RolDAO(rs.getInt("id"));
					this.name = rs.getString("id");
					this.level = rs.getInt("id");
					this.strenght = rs.getInt("id");
					this.dexerity = rs.getInt("id");
					this.intelligence = rs.getInt("id");
					this.information = rs.getString("id");
					this.height = rs.getInt("id");
					this.weight = rs.getInt("id");
					this.contains=new RolDAO(rs.getInt("id_Rol"));
				}			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int SavePlayer() {
		int rs=0;
		Connection con = ConnectionDB.getConexion();
		if(this.contains==null) {
			this.contains=new Rol();
		}
		if (con != null) {
			try {
				PreparedStatement q=con.prepareStatement(EnumBBDD.INSERTUPDATEPLAYER.getString());
				q.setInt(1, this.id);
				q.setString(2, this.name);
				q.setInt(3, this.level);
				q.setInt(4, this.strenght);
				q.setInt(5, this.dexerity);
				q.setInt(6, this.intelligence);
				q.setString(7, this.information);
				q.setInt(8, this.height);
				q.setInt(9, this.weight);
				q.setString(10, this.classRol);
				q.setInt(11, this.age);
				q.setInt(12, this.contains!=null?this.contains.id:-1);
				rs =q.executeUpdate();		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}


	public int deletePlayer() {
		int rs=0;
		Connection con = ConnectionDB.getConexion();		
		if (con != null) {
			try {
				PreparedStatement q=con.prepareStatement(EnumBBDD.DELETEPLAYER.getString());
				q.setInt(1, this.id);
				rs =q.executeUpdate();
				this.id=-1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}

	
	public Rol getMyRol() {
		if(this.contains==null || this.contains.getId() == -1) {
			this.contains=RolDAO.getRolByPlayer(this.id);
		}
		return super.getContains();
	}

	
	public static List<Player> getPlayerByRol(int id) {
		List<Player> listPlayers=new ArrayList<Player>();
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement q=con.prepareStatement(EnumBBDD.GETPLAYERBYMATER.getString());
				q.setInt(1, id);
				ResultSet rs =q.executeQuery();
				while(rs.next()) { 	
					Player auxP=new Player();
					auxP.setId(rs.getInt("id"));
					auxP.setName(rs.getString("name"));
					auxP.setLevel(rs.getInt("level"));
					auxP.setStrenght(rs.getInt("strength"));
					auxP.setDexerity(rs.getInt("dexerity"));
					auxP.setIntelligence(rs.getInt("intelligence"));
					auxP.setInformation(rs.getString("information"));
					auxP.setHeight(rs.getInt("height"));
					auxP.setWeight(rs.getInt("weight"));
					auxP.setClassRol(rs.getString("class"));
					auxP.setAge(rs.getInt("age"));
					
					Rol auxR = new Rol();
					auxR.setId(rs.getInt("id"));
					auxR.setName(rs.getString("name"));
					auxR.setDescription(rs.getString("description"));
					auxP.setContains(auxR);
					//maybe create Master
					listPlayers.add(auxP);
				}			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listPlayers;
	}
}
