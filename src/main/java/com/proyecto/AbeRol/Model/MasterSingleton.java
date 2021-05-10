package com.proyecto.AbeRol.Model;

public class MasterSingleton {

	private MasterDAO auxMaster;
	private final static MasterSingleton INSTANCE = new MasterSingleton();

	private MasterSingleton() {
		  }

	public static MasterSingleton getInstance() {
		return INSTANCE;
	}

	public void setUser(MasterDAO u) {
		this.auxMaster = u;
	}

	public MasterDAO getUser() {
		return this.auxMaster;

	}
}
