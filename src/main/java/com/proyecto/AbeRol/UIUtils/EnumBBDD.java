package com.proyecto.AbeRol.UIUtils;

public enum EnumBBDD {
	UPDATEMASTER("UPDATE Master SET name= ?,email=?,password =? Where id = ?"),
	UPDATEROL("UPDATE Rol SET name= ?,description=? Where id = ?"),
	SELECTMASTERS("SELECT name FROM Master"),
	SELECTROL("SELECT name FROM Rol"),
	SELECTPLAYERS("SELECT name FROM player"),
	LOGINMENU("SELECT name,password FROM Master WHERE name LIKE ? and password LIKE ?"), 
	GETMASTERBYEMAIL("SELECT id,name,password FROM Master WHERE email = ?"),
	GETMASTERBYNAMEPASS("SELECT id,name,password,email FROM Master WHERE name = ? AND password =?"), 
	GETMASTERBYID("SELECT id,name,password,email FROM Master WHERE id = ?"), 
	GETROLBYMASTER("SELECT id,name,description FROM Rol WHERE id_master = ?"), 
	GETROLBYID("SELECT id,name,description,id_Master FROM Rol WHERE id=?"),
	GETROLBYNAME("SELECT id, name, description, id_master FROM rol WHERE name =?"),
	INSERTUPDATEMASTER(
			"INSERT INTO Master (name, email, password) VALUES (?,?,?) ON DUPLICATE KEY UPDATE name= ?, "
					+ "email = ?, password= ?"), 
	INTERTUPDATEROL(
			"INSERT INTO Rol (name,description) VALUES(?,?) ON DUPLICATE KEY UPDATE name= ?, description= ?"), 

	GETPLAYERSBYROL("SELECT id, name, level, strength, dexerity, intelligence, information, height, weight, class, age, id_Rol FROM player WHERE id_Rol = ? "),/**/
	
	GETPLAYERBYID("SELECT id, name, level, strength, dexerity, intelligence, information, height, weight, class, age, id_Rol FROM player WHERE id = ?"),
	GETPLAYERBYNAME("SELECT id, name, level, strength, dexerity, intelligence, information, height, weight, class, age, id_Rol FROM player WHERE name = ?"),
	INSERTUPDATEPLAYER(
			"INSERT INTO Player (name, level, strength, dexerity, intelligence, information, height, weight, classRol, age, contains) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE name=?,level=?,strength=?,dexerity=?,intelligence=?"
					+ ",information=?,height=?,weight=?,classRol=?,age=?,contains=?"),

	
	DELETEMASTER("DELETE FROM Master WHERE name = ?"), /**/
	DELETEPLAYER("DELETE FROM Player WHERE id = ?"), /**/
	DELETEROL("DELETE FROM Rol WHERE name = ?");/**/

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
