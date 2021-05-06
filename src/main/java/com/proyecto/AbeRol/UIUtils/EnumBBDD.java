package com.proyecto.AbeRol.UIUtils;

public enum EnumBBDD {
	
	LOGINMENU("SELECT name,password FROM Master WHERE name LIKE ? and password LIKE ?"), /**/
	GETPLAYERBYID("SELECT id, name, level, strength, dexerity, intelligence, information , height, weight, class, age FROM player WHERE id =?"),//
	GETMASTERBYEMAIL("SELECT name,password FROM Master WHERE email = ?"), /**/
	GETMASTERBYID("SELECT id,name,password,email,rol FROM Master ma, Rol ro WHERE id = ? and "), /**/
    INSERTUPDATEMASTER("INSERT INTO Master (name, email, password) VALUES (?,?,?) ON DUPLICATE KEY UPDATE name=?, email =?, password=?"), /**/
    INSERTUPDATEPLAYER("INSERT INTO Player (id,name, level, strength, dexerity, intelligence, information, height, weight, classRol, age, contains) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE name=?,level=?,strength=?,dexerity=?,intelligence=?"
			+ ",information=?,height=?,weight=?,classRol=?,age=?,contains=?"),
	DELETEMASTER ("DELETE FROM Master WHERE id=?"),/**/
	DELETEPLAYER("DELETE FROM Player WHERE id=?");
		
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
