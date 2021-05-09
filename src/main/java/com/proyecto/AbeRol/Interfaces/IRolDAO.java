package com.proyecto.AbeRol.Interfaces;

import java.util.List;

import com.proyecto.AbeRol.Model.Rol;


/**
 * IMasterDAO is the Master's DAO interface
 * @author Abepuoh
 *
 */
public interface IRolDAO {
	/**
	 * method to get the rols of each Master
	 * @param id to identify each rol
	 * @return the list of players for each rol
	 */
	public List<Rol> getRolByMaster(int id);
	/**
	* Save a new Rol in the base
	* @return 0 if successfully saved
	**/
	public int saveRol();
	/**
	* Delete a Rol starting from the id
	* @param id identify of the Rol
	* @return true if successfully removed
	**/
	public int deleteRol(String name);
	
}
