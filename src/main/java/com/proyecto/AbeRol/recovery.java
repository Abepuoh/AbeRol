package com.proyecto.AbeRol;

import java.net.URL;
import java.util.ResourceBundle;

import com.proyecto.AbeRol.Model.MasterDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class recovery {

	@FXML
	private TextField txtEmail;

	@FXML
	private Label labelUser;
	
	@FXML
	private Label labelPassword;
	
	@FXML
	private Button buttRecovery;
	
	@FXML
	private Button buttExit;

	@FXML
	public void initialize(URL url, ResourceBundle rb) {

	}
	@FXML
	public void recover() {
		String email = this.txtEmail.getText();	
		MasterDAO dummy = new MasterDAO();
		dummy.getMasterByEmail(email);
		dummy.getName();
		dummy.getPassword();
	
	}
	@FXML
    private void exit(ActionEvent event) {
        Stage stage = (Stage) this.buttExit.getScene().getWindow();
        stage.close();
 
    }
}
