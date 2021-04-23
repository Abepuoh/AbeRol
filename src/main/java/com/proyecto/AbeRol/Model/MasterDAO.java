package com.proyecto.AbeRol.Model;


import java.util.List;

import com.proyecto.AbeRol.UIUtils.*;

public class MasterDAO extends Master implements IMasterDAO {

	public MasterDAO(int id, String name, String surname, String password, List<Rol> rol) {
		super(id, name, surname, password, rol);

	}

	public MasterDAO() {
		super();
	}

	public MasterDAO(int id) {
		super(id);
	}

	public MasterDAO(String name, String password) {
		super(name, password);
	}

	public MasterDAO(String email) {
		super(email);
	}

	@Override
	public boolean KeepM() {
		return false;
	}

	@Override
	public boolean newMaster(String email, String name, int password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Master getMaster() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Master getMasterByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteM(int id) {
		return false;
	}

}