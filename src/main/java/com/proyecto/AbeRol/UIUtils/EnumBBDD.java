package com.proyecto.AbeRol.UIUtils;

public enum EnumBBDD {

	LOGINMENU("SELECT name,password FROM Master WHERE name LIKE ? and password LIKE ?"), /**/
	GETMASTERBYEMAIL("SELECT id,name,password FROM Master WHERE email = ?"), /**/
	GETMASTERBYNAME("SELECT name,password,email,rol FROM Master WHERE name = ?"), /**/
	GETMASTERBYID("SELECT name,password,email FROM Master WHERE id = ?"), /**/
	GETROLBYMASTER("SELECT ro.name,description FROM Rol ro,Master ma WHERE ro.id_master=ma.id AND ro.id_master=?"),
	GETROLBYMASTERNAME("SELECT id,name,description FROM Rol WHERE id_master = ?"), /**/
	GETROLBYNAME("SELECT id,name,description,id_Master FROM Rol WHERE name=?"), /**/
	INSERTUPDATEMASTER(
			"INSERT INTO Master (name, email, password) VALUES (?,?,?) ON DUPLICATE KEY UPDATE name= ?, "
					+ "email = ?, password= ?"), /**/
	INTERTUPDATEROL(
			"INSERT INTO Rol (name,description, id_Master) VALUES(?,?,?) ON DUPLICATE KEY UPDATE name= ?, description= ?, id_Master = ?"), /**/

	GETPLAYERBYMATER("SELECT p.id, p.name, p.level, p.strength, p.dexerity, p.intelligence, p.information , p.height, p.weight, p.class, p.age, p.id_Rol,r.name,"
			+ "r.description FROM Player p,Rol r WHERE p.id_Rol = r.id AND p.id_Rol=?"),
	
	GETPLAYERBYID(
			"SELECT id, name, level, strength, dexerity, intelligence, information , height, weight, class, age, id_Rol FROM player WHERE id = ?"), //
	INSERTUPDATEPLAYER(
			"INSERT INTO Player (id,name, level, strength, dexerity, intelligence, information, height, weight, classRol, age, contains) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE name=?,level=?,strength=?,dexerity=?,intelligence=?"
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
