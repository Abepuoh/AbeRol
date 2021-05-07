package com.proyecto.AbeRol;
import java.io.IOException;
import java.util.Optional;

import com.proyecto.AbeRol.Model.MasterDAO;
import com.proyecto.AbeRol.Model.Player;
import com.proyecto.AbeRol.Model.Rol;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class mainMenu  {
	
	@FXML
	private Button deleteMasterButt;

	@FXML
	private Button deleteRolButt;

	@FXML
	private Button addRolButt;

	@FXML
	private Button buttExit;

	@FXML
	private ComboBox<Rol> choiceRol;
	@FXML 
	private ObservableList<Player> Players;
	@FXML
	private Label pitoDeLeche;
	
	@FXML
	public void initialize() {
	 MasterDAO u = new MasterDAO();
	//this.choiceRol.setItems((ObservableList<Rol>) u.getRol());
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
	protected void setColumn1() {
		//this.pitoDeLeche..set(choiceRol.getSelectionModel().getSelectedItem());
	}
	
	@FXML
    private void exit(ActionEvent event) {
        Stage stage = (Stage) this.buttExit.getScene().getWindow();
        stage.close();
 
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
