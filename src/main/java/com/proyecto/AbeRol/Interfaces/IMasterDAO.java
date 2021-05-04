package com.proyecto.AbeRol.Interfaces;

import com.proyecto.AbeRol.Model.Master;
/**
 * IMasterDAO is the Master's DAO interface
 * @author Abepuoh
 *
 */
public interface IMasterDAO  {
	/**
	* Save a new master in the base
	* @return true if successfully saved
	**/
	public int SaveMaster();
	/**
	* Create a new master
	* @return true if the master was created successfully
	**/
	public boolean createAccount(String name, String email, String password);
	/**
	* Obtain Master thanks to the identifier
	* @param id identifier of the master
	* @return returns the master that we have entered
	*/
	public Master getMasterByEmail(String email);
	/**
	* Delete a master starting from the id
	* @param id identify of the master
	* @return true if successfully removed
	**/
	public int deleteMaster(int id);
	/**
	 * Method to start session if the master is in the database
	 * @param name 
	 * @param password
	 * @returns true if the master is in the database
	 */
	public boolean logIn(String name,String password);
}
