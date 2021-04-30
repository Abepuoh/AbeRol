package com.proyecto.AbeRol.UIUtils;

public enum EnumBBDD {
	/* PRIMERA ESCENA
	 * FORGET EMAIL
	 * CREATE MASTER 
	 * LOGIN
	 */
	LOGINMENU("SELECT name,password FROM Master WHERE name LIKE ? and password LIKE ?"),
    GETBYEMAIL("SELECT name,password,email FROM autor WHERE email = ?"), 
    INSERTMASTER("INSERT INTO master (email, name, password) VALUES (?,?,?)"),
    SELECTMASTER("SELECT name,password,email FROM autor"),
	DELETE ("DELETE FROM Master WHERE id=?");
	
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
   
}
