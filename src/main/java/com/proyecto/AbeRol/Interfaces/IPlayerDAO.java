package com.proyecto.AbeRol.Interfaces;

import java.util.List;

import com.proyecto.AbeRol.Model.Player;
import com.proyecto.AbeRol.Model.Rol;

public interface IPlayerDAO {
	/**
	* Save a new Player in the base
	* @return 0 if successfully saved
	**/
	public int SavePlayer();
	/**
	* Delete a Player starting from the id
	* @param id identify of the rol
	* @return true if successfully removed
	**/
	public int deletePlayer();
	/**
	 * Returns the rol of a player
	 * @return the player´s rol
	 */
	public Rol getMyRol();
	/**
	 * Method that returns a list of players
	 * @param name of the Rol
	 * @return a list of players
	 */
	public List<Player> getPlayerByRol(int id);
}
