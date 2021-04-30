package com.proyecto.AbeRol;

import java.net.URL;
import java.util.ResourceBundle;

import com.proyecto.AbeRol.Model.Master;
import com.proyecto.AbeRol.UIUtils.Verify;

import javafx.collections.ObservableList;
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

	private Master master;
	
	private ObservableList<Master> masters;
	
	public void initialize(URL url, ResourceBundle rb) {

	}

//	public void initAttributtes(ObservableList<Master> p) {
//		this.masters = p;
//	}
	@FXML
	private void guardarPersona(ActionEvent event) {
		
		String name = this.txtName.getText();
		String password = this.txtPass.getText();
		String email = this.txtEmail.getText();
		Master dummy = Verify.verifyUser(name, password, email);
		
		if (!masters.contains(dummy) && dummy != null) {
			this.master = dummy;
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Informacion");
			alert.setContentText("Se ha añadido correctamente");
			alert.showAndWait();
			Stage stage = (Stage) this.buttCreate.getScene().getWindow();
			stage.close();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Este usuario ya existe");
			alert.showAndWait();
		}

	}
	
	@FXML
	private void salir(ActionEvent event) {
		this.master = null;
		Stage stage = (Stage) this.buttCreate.getScene().getWindow();
		stage.close();

	}

	public Master getMaster() {
		return master;
	}
}
