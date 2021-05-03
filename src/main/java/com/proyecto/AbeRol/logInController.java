package com.proyecto.AbeRol;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.proyecto.AbeRol.Model.Master;
import com.proyecto.AbeRol.Model.MasterDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class logInController {

	@FXML
	private TextField txtUser;
	@FXML
	private PasswordField txtPass;
	@FXML
	private Hyperlink txtForget;
	@FXML
	private Hyperlink buttCreate;
	@FXML
	private Button LogButt;

	@FXML
	public void initialize(URL url, ResourceBundle rb) {
	
	}

	@FXML
	protected void logUser(ActionEvent Event) throws IOException {
		String name = this.txtUser.getText();
		String password = this.txtPass.getText();
		   if(MasterDAO.logIn(name, password)== true){
		   OpenMenu();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Has introducido mal algun dato");
			alert.showAndWait();
		}
	}

	@FXML
	protected void addMaster(ActionEvent Event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("signUp.fxml"));
        Parent modal;
        modal = fxmlLoader.load();
        Stage modalStage = new Stage();
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.initOwner(App.rootstage);

        Scene modalScene = new Scene(modal);
        modalStage.setScene(modalScene);
        modalStage.showAndWait();
	}
	
	@FXML
	protected void recoveryMaster(ActionEvent Event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("recovery.fxml"));
        Parent modal;
        modal = fxmlLoader.load();
        Stage modalStage = new Stage();
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.initOwner(App.rootstage);
        modalStage.showAndWait();
	}
	
	public void OpenMenu() {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("mainMenu.fxml"));
	        Parent modal;
	        try {
	            modal = fxmlLoader.load();
	            Stage modalStage = new Stage();
	            modalStage.initModality(Modality.APPLICATION_MODAL);
	            modalStage.initOwner(App.rootstage);
	            Scene modalScene = new Scene(modal);
	            modalStage.setScene(modalScene);
                modalStage.showAndWait();

	        } catch (IOException ex) {
	            Logger.getLogger(logInController.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
}
