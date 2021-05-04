package com.proyecto.AbeRol.Interfaces;

import java.util.List;

import com.proyecto.AbeRol.Model.Player;

/**
 * IMasterDAO is the Master's DAO interface
 * @author Abepuoh
 *
 */
public interface IRolDAO {
	/**
	 * method to get all the players of each role
	 * @param id to identify each rol
	 * @return the list of players for each rol
	 */
	public List<Player> getPlayerbyRol(int id);
	/**
	* Save a new Rol in the base
	* @return true if successfully saved
	**/
	public boolean SaveRol();
	/**
	* Delete a Rol starting from the id
	* @param id identify of the Rol
	* @return true if successfully removed
	**/
	public boolean deleteRol(int id);
}
