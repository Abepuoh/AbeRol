package com.proyecto.AbeRol;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
		
	}
	@FXML
    private void exit(ActionEvent event) {
        Stage stage = (Stage) this.buttExit.getScene().getWindow();
        stage.close();
 
    }
}
