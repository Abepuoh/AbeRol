package com.proyecto.AbeRol.Model;

public class Class {
	
	private String race;
	private int dices; //dados

	public Class(String race, int dices) {
		super();
		this.race = race;
		this.dices = dices;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String raza) {
		this.race = raza;
	}

	public int getDices() {
		return dices;
	}

	public void setDices(int dadoGolpe) {
		this.dices = dadoGolpe;
	}
}
