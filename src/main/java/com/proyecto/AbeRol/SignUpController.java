package com.proyecto.AbeRol;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import com.proyecto.AbeRol.Model.MasterDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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

	public void initialize(URL url, ResourceBundle rb) {

	}

	@FXML
	private void saveMaster(ActionEvent event) {
		String name = this.txtName.getText();
		String password = this.txtPass.getText();
		String email = this.txtEmail.getText();
		MasterDAO dummy = new MasterDAO(name, password, email);
		if (dummy.logIn(name, password) == true) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("La persona ya existe");
			alert.showAndWait();	
		}else if(dummy.createAccount(name, email, password) == 0) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Informacion");
			alert.setContentText("Se ha añadido correctamente");
			alert.showAndWait();
		}
	}
	@FXML
    private void exit(ActionEvent event) {
        Stage stage = (Stage) this.buttSave.getScene().getWindow();
        stage.close();
 
    }

}
