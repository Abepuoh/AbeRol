package com.proyecto.AbeRol.UIUtils;

public enum EnumBBDD {
	/* PRIMERA ESCENA
	 * FORGET EMAIL
	 * CREATE MASTER 
	 * LOGIN
	 */
	GETPLAYERBYID("SELECT id, name, level, strength, dexerity, intelligence, information , height, weight, class, age FROM player WHERE id =?"),
	LOGINMENU("SELECT name,password FROM Master WHERE name LIKE ? and password LIKE ?"),
    GETBYEMAIL("SELECT name,password FROM autor WHERE email = ?"), //CH
    GETBYID("SELECT id,name,password,email,rol FROM Master ma, Rol ro WHERE id = ? and "), //Ch
    INSERTUPDATE("INSERT INTO Master (name, email, password) VALUES (?,?,?)"),
    INSERTUPDATEPLAYER("INSERT INTO Player (id,name, level, strength, dexerity, intelligence, information, height, weight, classRol, age, contains) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE name=?,level=?,strength=?,dexerity=?,intelligence=?"
			+ ",information=?,height=?,weight=?,classRol=?,age=?,contains=?"),
	DELETEMASTER ("DELETE FROM Master WHERE id=?"),
	DELETEPLAYER("DELETE FROM Player WHERE id=?"),
	SELECTROLBYID("SELECT name FROM Rol,Master ma WHERE id_master = ma.id "),
	SELECTPLAYERS("SELECT id,name, level, strength, dexerity, intelligence, information, height, weight, classRol, age, contains "
			+ "FROM libro WHERE id=\" ");
	
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
