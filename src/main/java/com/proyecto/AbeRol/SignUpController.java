package com.proyecto.AbeRol;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import com.proyecto.AbeRol.Model.MasterDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;


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
		String name = this.txtName.getText();
		String password = this.txtPass.getText();
		String email = this.txtEmail.getText();
		MasterDAO dummy = new MasterDAO(name,password,email);
		if(dummy.createAccount(name, email, password) ==true) {
			showInfo();
			//close();
		}else {
			showWarning("Error de validación", "Has introducido mal algun dato", "Asegurate que los campos introducidos "
					+ "son correctos.");
		}
	}
	public static void showWarning(String title, String header, String description) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(description);
        alert.showAndWait();
    }

    public void showInfo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Enhorabuena"+this.txtName+" has creado tu cuenta correctamente");
        alert.setContentText("Ahora toca disfrutar!!!.");
        Optional<ButtonType> result = alert.showAndWait();
    }

}
