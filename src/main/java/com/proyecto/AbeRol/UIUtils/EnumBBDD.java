package com.proyecto.AbeRol.UIUtils;

public enum EnumBBDD {
	SELECTMASTERS("SELECT name FROM Master"),
	LOGINMENU("SELECT name,password FROM Master WHERE name LIKE ? and password LIKE ?"), 
	GETMASTERBYEMAIL("SELECT name,password FROM Master WHERE email = ?"),
	GETMASTERBYNAME("SELECT name,password,email,rol FROM Master WHERE name = ?"), 
	GETMASTERBYID("SELECT id,name,password,email FROM Master WHERE id = ?"), 
	GETROLBYMASTER("SELECT id,name,description FROM Rol WHERE id_master = ?"), 
	GETROLBYNAME("SELECT id,name,description,id_Master FROM Rol WHERE id=?"),
	INSERTUPDATEMASTER(
			"INSERT INTO Master (name, email, password) VALUES (?,?,?) ON DUPLICATE KEY UPDATE name= ?, "
					+ "email = ?, password= ?"), 
	INTERTUPDATEROL(
			"INSERT INTO Rol (name,description, id_Master) VALUES(?,?,?) ON DUPLICATE KEY UPDATE name= ?, description= ?, id_Master = ?"), 

	GETPLAYERSBYROL("SELECT id, name, level, strength, dexerity, intelligence, information, height, weight, class, age, id_Rol FROM player WHERE id_Rol = ? "),/**/
	
	GETPLAYERBYID("SELECT id, name, level, strength, dexerity, intelligence, information, height, weight, class, age, id_Rol FROM player WHERE id = ?"),
	INSERTUPDATEPLAYER(
			"INSERT INTO Player (name, level, strength, dexerity, intelligence, information, height, weight, classRol, age, contains) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE name=?,level=?,strength=?,dexerity=?,intelligence=?"
					+ ",information=?,height=?,weight=?,classRol=?,age=?,contains=?"),

	
	DELETEMASTER("DELETE FROM Master WHERE id = ?"), /**/
	DELETEPLAYER("DELETE FROM Player WHERE id = ?"), /**/
	DELETEROL("DELETE FROM Rol WHERE id = ?");/**/

	private String select;

	EnumBBDD(String select) {
		this.select = select;
	}

	public String getBBDD() {
		return select;
	}

	public void setConstante(String select) {
		this.select = select;
	}

	public String getString() {
		return this.select;
	}
}
