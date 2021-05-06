package com.proyecto.AbeRol;

import java.net.URL;
import java.util.ResourceBundle;

import com.proyecto.AbeRol.Model.Master;
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
	
	private Stage myStage;
	
	@FXML
	public void initialize(URL url, ResourceBundle rb) {
		myStage.getIcons().add(new Image(App.class.getResourceAsStream("logo.png")));
	}

	@FXML
	private void saveMaster(ActionEvent event) {
		String name = this.txtName.getText();
		String password = this.txtPass.getText();
		String email = this.txtEmail.getText();
		if(name.trim().length() > 0 && email.trim().length() > 0 && password.trim().length() > 0) {	
		MasterDAO dummy = new MasterDAO(name,email ,password);
		dummy.SaveMaster();
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
