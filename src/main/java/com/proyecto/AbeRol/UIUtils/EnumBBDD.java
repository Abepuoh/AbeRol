package com.proyecto.AbeRol.UIUtils;

public enum EnumBBDD {

	LOGINMENU("SELECT name,password FROM Master WHERE name LIKE ? and password LIKE ?"), /**/
	GETMASTERBYEMAIL("SELECT name,password FROM Master WHERE email = ?"), /**/
	GETMASTERBYNAME("SELECT name,password,email,rol FROM Master WHERE name = ?"), /**/
	GETMASTERBYID("SELECT name,password,email,rol FROM Master WHERE id = ?"), /**/
	GETROLBYMASTERNAME("SELECT name,description FROM Rol WHERE id_master = ?"), /**/
	GETROLBYNAME("SELECT name,description,dni_master, autor FROM libro WHERE name=?"), /**/
	INSERTUPDATEMASTER(
			"INSERT INTO Master (name, email, password) VALUES (?,?,?) ON DUPLICATE KEY UPDATE name= ?, "
					+ "email = ?, password= ?"), /**/
	INTERTUPDATEROL(
			"INSERT INTO Rol (name,description, id_Master) VALUES(?,?,?) ON DUPLICATE KEY UPDATE name= ?, description= ?, id_Master = ?"), /**/

	
	GETPLAYERBYID(
			"SELECT id, name, level, strength, dexerity, intelligence, information , height, weight, class, age FROM player WHERE id = ?"), //
	INSERTUPDATEPLAYER(
			"INSERT INTO Player (id,name, level, strength, dexerity, intelligence, information, height, weight, classRol, age, contains) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE name=?,level=?,strength=?,dexerity=?,intelligence=?"
					+ ",information=?,height=?,weight=?,classRol=?,age=?,contains=?"),

	
	DELETEMASTER("DELETE * FROM Master WHERE name = ?"), /**/
	DELETEPLAYER("DELETE FROM Player WHERE name = ?"), /**/
	DELETEROL("DELETE * FROM Rol WHERE name = ?");/**/

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
