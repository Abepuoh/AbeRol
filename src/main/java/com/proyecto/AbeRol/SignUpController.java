package com.proyecto.AbeRol;

import com.proyecto.AbeRol.Model.MasterDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SignUpController {

	@FXML
	private TextField txtName;
	@FXML
	private TextField txtPass;
	@FXML
	private TextField txtEmail;
	@FXML
	private Button buttCreate;
	@FXML
	private Button buttSave;

	@FXML
	public void initialize() {

	}

	@FXML
	private void saveMaster(ActionEvent event) {
		String name = this.txtName.getText();
		String email = this.txtEmail.getText();
		String password = this.txtPass.getText();
		if (name.trim().length() > 0 && email.trim().length() > 0 && password.trim().length() > 0 && name != null
				&& email != null && password != null) {
			MasterDAO dummyDao = new MasterDAO(email);
			if (dummyDao.logIn(name, password) == false) {
				MasterDAO dummy = new MasterDAO(name, email, password);
				dummy.SaveMaster();
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("Informacion");
				alert.setContentText("Se ha añadido correctamente");
				alert.showAndWait();
			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error de creacion");
				alert.setContentText("El usuario ya existe, recuerde que siempre puede recuperar su cuenta");
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
	private void exit(ActionEvent event) {
		Stage stage = (Stage) this.buttSave.getScene().getWindow();
		stage.close();

	}

}
