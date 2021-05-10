package com.proyecto.AbeRol;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.proyecto.AbeRol.Model.Master;
import com.proyecto.AbeRol.Model.MasterDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class editMasterController {

	@FXML
	private TextField txtName;
	@FXML
	private TextField txtEmail;
	@FXML
	private TextField txtPassword;
	@FXML
	private Button buttEdit;
	@FXML
	private Button buttDelete;
	@FXML
	private Button buttExit;

	MasterDAO dummy = new MasterDAO();

	@FXML
	public void initialize() {
		int id = 1;
		dummy = new MasterDAO(id);
	}

	@FXML
	private void editMaster(ActionEvent event) throws IOException {
		String name = this.txtName.getText();
		String email = this.txtEmail.getText();
		String password = this.txtPassword.getText();

		if (!this.txtName.getText().trim().isEmpty() && !this.txtPassword.getText().trim().isEmpty()
				&& !this.txtEmail.getText().trim().isEmpty()) {
			List<String> dummyDao = MasterDAO.getMasters();
			if (!dummyDao.contains(name)) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error de edicion");
				alert.setContentText("Tiene que introducir su usuario");
				alert.showAndWait();
			} else {
				Master dummy = new Master(name, email, password);
				MasterDAO aux = new MasterDAO(dummy);
				aux.SaveMaster();
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
	private void deleteMaster(ActionEvent event) throws IOException {

		if (dummy != null) {
			if (showConfirm(dummy.getName()) == true) {
				dummy.deleteMaster(dummy.getName());
			}
		}
	}

	public boolean showConfirm(String nombre) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Confirme la acción");
		alert.setHeaderText("¿Esta seguro de borrar su usuario, " + nombre + "?");
		alert.setContentText("Está a punto de eliminar su perfil, perderas todos tus datos ¿desea hacerlo?");
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
		alert.setHeaderText("¿Estas seguro de querer modificar tus datos " + nombre + "?");
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
