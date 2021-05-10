package com.proyecto.AbeRol;

import java.io.IOException;
import java.util.Optional;

import com.proyecto.AbeRol.Model.MasterDAO;
import com.proyecto.AbeRol.Model.PlayerDAO;
import com.proyecto.AbeRol.Model.Rol;
import com.proyecto.AbeRol.Model.RolDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class editRolController {
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtDesc;
	@FXML
	private Button buttEdit;
	@FXML
	private Button buttDelete;
	@FXML
	private Button buttExit;
	@FXML
	private ComboBox <Rol> comboRol;
	
	

	MasterDAO user=new MasterDAO(1);
	
		@FXML
	public void initialize() {
		System.out.println(user.getMisobras().toString());	
		this.comboRol.setItems(RolDAO.getRolByMaster(user.getId()));
	}

	@FXML
	private void editRol(ActionEvent event) throws IOException {
		String name = this.txtName.getText();
		String desc = this.txtDesc.getText();
		
		if (dummy != null) {
			dummy.setName(name);
			dummy.setDescription(desc);
		
			if(showEdit(dummy.getName()) == true) {
				dummy.saveRol();
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("Usuario Editado ");
				alert.setContentText("Ha sido todo un exito, has editado tu usuario");
				alert.showAndWait();
			}		
		}
	}
	
	@FXML
	private void deleteRol(ActionEvent event) throws IOException {

		if (dummy != null) {
			if (showConfirm(dummy.getName()) == true) {
				dummy.deleteRol(dummy.getName());
			}
		}
	}

	public boolean showConfirm(String nombre) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Confirme la acción");
		alert.setHeaderText("¿Esta seguro de borrar su partida llamada " + nombre + "?");
		alert.setContentText("Está a punto de eliminar su partida, perderas todos tus datos ¿desea hacerlo?");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean showEdit(String nombre) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Confirme la acción");
		alert.setHeaderText("¿Estas seguro de querer modificar los datos de " + nombre + "?");
		alert.setContentText("Si continuas tus datos seran modificados");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			return true;
		} else {
			return false;
		}
	}

	@FXML
	private void exit(ActionEvent event) {
		Stage stage = (Stage) this.buttExit.getScene().getWindow();
		stage.close();

	}
}
