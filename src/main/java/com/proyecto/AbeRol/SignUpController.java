package com.proyecto.AbeRol;

import java.util.List;

import com.proyecto.AbeRol.Model.Master;
import com.proyecto.AbeRol.Model.MasterDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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

		if (!this.txtName.getText().trim().isEmpty() && !this.txtPass.getText().trim().isEmpty()
				&& !this.txtEmail.getText().trim().isEmpty()) {
			 List<String> dummyDao = MasterDAO.getMasters();
			if (!dummyDao.contains(name)) {
				Master dummy = new Master(name, email, password);
				MasterDAO aux = new MasterDAO(dummy);
				aux.SaveMaster();
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
