package com.proyecto.AbeRol;

import java.net.URL;
import java.util.ResourceBundle;

import com.proyecto.AbeRol.Model.Master;
import com.proyecto.AbeRol.Model.MasterDAO;
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

	
	public void initialize(URL url, ResourceBundle rb) {

	}

	@FXML
	private void saveMaster(ActionEvent event) {

	}
	
	@FXML
	private void salir(ActionEvent event) {
		Stage stage = (Stage) this.buttCreate.getScene().getWindow();
		stage.close();

	}

}
