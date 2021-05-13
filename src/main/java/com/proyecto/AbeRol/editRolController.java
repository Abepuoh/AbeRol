package com.proyecto.AbeRol;

import java.io.IOException;
import java.util.Optional;

import com.proyecto.AbeRol.Model.MasterDAO;
import com.proyecto.AbeRol.Model.MasterSingleton;
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
	private ComboBox<Rol> comboRol;

	MasterDAO user = new MasterDAO();

	@FXML
	public void initialize() {
		MasterSingleton transfer = MasterSingleton.getInstance();
		user = transfer.getUser(); 
		this.comboRol.setItems(user.getRol());

	}

	@FXML
	private void editRol(ActionEvent event) throws IOException {
		String name = this.txtName.getText();
		String desription = this.txtDesc.getText();
		RolDAO auxRol = new RolDAO(this.comboRol.getValue().toString());
		if (!this.txtName.getText().trim().isEmpty() && !this.txtDesc.getText().trim().isEmpty()
				&& !comboRol.getSelectionModel().isEmpty()) {

			if (this.txtName.getText().equals(this.comboRol.getValue().toString())) {
				Rol dummy = new Rol(name, desription);
				RolDAO aux = new RolDAO(dummy);
				aux.updateRol(auxRol.getId());
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("Informacion");
				alert.setContentText("Se ha añadido correctamente");
				alert.showAndWait();
			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error de edicion");
				alert.setContentText("Solo puede editar sus partida");
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
		String selectedItem = comboRol.getValue().toString();

		if (showConfirm(selectedItem) == true) {
			RolDAO.deleteRol(selectedItem);
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Informacion");
			alert.setContentText("Se ha borrado correctamente");
			alert.showAndWait();
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
