package com.proyecto.AbeRol.UIUtils;

import com.proyecto.AbeRol.Model.Master;

public class Verify {
	
	public static Master verifyUser(String name, String pass, String email) {
		String emailRegex = "/[A-Z0-9._%+-]+@[A-Z0-9-]+.+.[A-Z]{2,4}/igm";
		String passRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$"; //8 caracteres, una letra mayúscula y un numero.
		String userRegex = "^[A-Za-z0-9!#$%&\"*+/=?^_`{|}~\\,.@()<>[]-]*$";
		Master dummy = null;
		if(emailRegex.matches(email) && passRegex.matches(pass) && userRegex.matches(name)) {
			dummy = new Master(name, pass, email);
		}else {
	//		System.out.println("");
		}
		return dummy;
	}
}
