package com.proyecto.AbeRol.Interfaces;

/**
 * IMasterDAO is the Master's DAO interface
 * @author Abepuoh
 *
 */
public interface IMasterDAO  {
	/**
	* Save a new master in the base
	* @return 0 if successfully saved
	**/
	public int SaveMaster();
	/**
	* Delete a master starting from the id
	* @param name of the master
	* @return 0 if successfully removed
	**/
	public int deleteMaster(String name);
}
