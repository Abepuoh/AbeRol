package com.proyecto.AbeRol.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.proyecto.AbeRol.UIUtils.EnumBBDD;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
		this.strength = dummy.strength;
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
				q.setInt(1,id);
				ResultSet rs = q.executeQuery();
				while(rs.next()) {
					this.id=rs.getInt("id");
					this.name = rs.getString("name");
					this.level = rs.getInt("level");
					this.strength = rs.getInt("strength");
					this.dexerity = rs.getInt("dexerity");
					this.intelligence = rs.getInt("intelligence");
					this.information = rs.getString("information");
					this.height = rs.getInt("height");
					this.weight = rs.getInt("weight");
					this.classRol = rs.getString("class");
					this.age = rs.getInt("age");
					this.contains = new RolDAO(rs.getInt("id_rol"));
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
				q.setInt(4, this.strength);
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

	public static ObservableList<Player> getPlayerByRol(int id) {
		
		ObservableList<Player> listPlayers=FXCollections.observableArrayList();
		Connection con = ConnectionDB.getConexion();
		if (con != null) {
			try {
				PreparedStatement q=con.prepareStatement(EnumBBDD.GETPLAYERSBYROL.getString());
				q.setInt(1, id);
				ResultSet rs =q.executeQuery();
				while(rs.next()) { 	
					Player auxP=new Player();
					auxP.setId(rs.getInt("id"));
					auxP.setName(rs.getString("name"));
					auxP.setLevel(rs.getInt("level"));
					auxP.setStrength(rs.getInt("strength"));
					auxP.setDexerity(rs.getInt("dexerity"));
					auxP.setIntelligence(rs.getInt("intelligence"));
					auxP.setInformation(rs.getString("information"));
					auxP.setHeight(rs.getInt("height"));
					auxP.setWeight(rs.getInt("weight"));
					auxP.setClassRol(rs.getString("class"));
					auxP.setAge(rs.getInt("age"));
					listPlayers.add(auxP);
				}			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listPlayers;
	}

	@Override
	public String toString() {
		return "PlayerDAO [id=" + id + ", classRol=" + classRol + ", age=" + age + ", contains=" + contains + ", name="
				+ name + ", level=" + level + ", strength=" + strength + ", dexerity=" + dexerity + ", intelligence="
				+ intelligence + ", information=" + information + ", height=" + height + ", weight=" + weight + "]";
	}
	
}
