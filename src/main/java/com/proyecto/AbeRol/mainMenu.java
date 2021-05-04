package com.proyecto.AbeRol;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import com.proyecto.AbeRol.Model.Rol;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;

public class mainMenu {

	@FXML
	private Button deleteMasterButt;

	@FXML
	private Button deleteRolButt;

	@FXML
	private Button addRolButt;

	@FXML
	private Button logOut;

	@FXML
	private ChoiceBox<Rol> choiceRol;

	@FXML
	public void initialize(URL url, ResourceBundle rb) {

	}

	@FXML
	protected void deleteMaster(ActionEvent Event) throws IOException {

	}

	@FXML
	protected void deleteRol(ActionEvent Event) throws IOException {

	}

	@FXML
	protected void addRol(ActionEvent Event) throws IOException {

	}
	@FXML 
	protected void editMaster(ActionEvent Event)throws IOException{
		
	}
	@FXML
	protected void logOut(ActionEvent Event) throws IOException {
		
	}
	public boolean showConfirm(String nombre) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirme la acción");
        alert.setHeaderText("¿Desea borrar el usuario " +nombre+ "?");
        alert.setContentText("Está a punto de eliminar su perfil, ¿desea hacerlo?");

           
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }
}
