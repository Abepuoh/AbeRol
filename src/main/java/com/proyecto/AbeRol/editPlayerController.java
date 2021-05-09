package com.proyecto.AbeRol;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class editPlayerController {
	
	@FXML
	private Button buttExit;
	
	@FXML
	public void initialize() {
		
	}
	
	@FXML
	private void exit(ActionEvent event) {
		Stage stage = (Stage) this.buttExit.getScene().getWindow();
		stage.close();

	}
}
