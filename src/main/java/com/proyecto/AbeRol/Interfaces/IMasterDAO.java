package com.proyecto.AbeRol.Interfaces;

import java.util.List;
import com.proyecto.AbeRol.Model.MasterDAO;
import com.proyecto.AbeRol.Model.Rol;

import javafx.collections.ObservableList;

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
	* Obtain Master thanks to the identifier
	* @param id identifier of the master
	* @return returns the master that we have entered
	*/
	public ObservableList<MasterDAO> getMasterByEmail(int id);
	/**
	* Delete a master starting from the id
	* @param name of the master
	* @return 0 if successfully removed
	**/
	public int deleteMaster(String name);
	/**
	 * Method to start session if the master is in the database
	 * @param name 
	 * @param password
	 * @returns true if the master is in the database
	 */
	public boolean logIn(String name,String password);
	/**
	 * Method that gets all roles given username
	 * @param name of the master
	 * @return the list of all roles
	 */
	public List<Rol> getRolsByMaster(String name);
}
