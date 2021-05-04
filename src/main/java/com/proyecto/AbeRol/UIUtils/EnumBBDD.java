package com.proyecto.AbeRol.UIUtils;

public enum EnumBBDD {
	/* PRIMERA ESCENA
	 * FORGET EMAIL
	 * CREATE MASTER 
	 * LOGIN
	 */
	LOGINMENU("SELECT name,password FROM Master WHERE name LIKE ? and password LIKE ?"),
    GETBYEMAIL("SELECT name,password FROM autor WHERE email = ?"), 
    GETBYID("SELECT id,name,password,email,rol FROM Master ma, Rol ro WHERE id = ? and "), 
    INSERTUPDATE("INSERT INTO Master (name, email, password,rol) VALUES (?,?,?,?) ON DUPLICATE KEY UPDATE name=?,email=?,password=?,rol=?"),
    SELECTPLAYERS("SELECT p.* FROM Player p,Contains con,Rol ro WHERE ro.id = con.id_rol and p.id = con.id_player "),
	DELETE ("DELETE FROM Master WHERE id=?"),
	SELECTROLBYID("SELECT name FROM Rol,Master ma WHERE id_master = ma.id ");
	
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
