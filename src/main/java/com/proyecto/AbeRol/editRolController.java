package com.proyecto.AbeRol;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.proyecto.AbeRol.Model.Master;
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

		this.comboRol.setItems(user.getRol());
		System.out.println(comboRol.getItems().get(1));
	}

	@FXML
	private void editRol(ActionEvent event) throws IOException {
		String name = this.txtName.getText();
		String desription = this.txtDesc.getText();
		if (!this.txtName.getText().trim().isEmpty() && !this.txtDesc.getText().trim().isEmpty()) {
			List<String> dummyDao = RolDAO.getRols();
			if (!dummyDao.contains(comboRol.getItems().get(1).toString())) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error de edicion");
				alert.setContentText("Tiene que introducir su usuario");
				alert.showAndWait();
			} else {
				Rol dummy = new Rol(name,desription);
				RolDAO aux = new RolDAO(dummy);
				aux.saveRol();
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("Informacion");
				alert.setContentText("Se ha añadido correctamente");
				alert.showAndWait();

			}
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error de creacion");
			alert.setContentText("Porfavor no deje ningun dato vacío");
			alert.showAndWait();
		}
	}
	
	@FXML
	private void deleteRol(ActionEvent event) throws IOException {
			if (showConfirm(comboRol.getItems().get(1).toString()) == true) {
				RolDAO.deleteRol(comboRol.getItems().get(1).toString());
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
