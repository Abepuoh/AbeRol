package com.proyecto.AbeRol;

import java.io.IOException;

import com.proyecto.AbeRol.Model.MasterDAO;
import com.proyecto.AbeRol.Model.MasterSingleton;

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
	public void initialize() {

	}

	@FXML
	protected void logUser(ActionEvent Event) throws IOException {
		String name = this.txtUser.getText();
		String password = this.txtPass.getText();
		MasterDAO root = new MasterDAO();
		MasterSingleton transfer =MasterSingleton.getInstance();
		this.txtPass.clear();
		if (root.logIn(name, password) == true) {
			MasterDAO data = new MasterDAO(name,password);
			transfer.setUser(data);
			App.setRoot("mainMenu");
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error de acceso");
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
		Scene modalScene = new Scene(modal);
		modalStage.setScene(modalScene);
		modalStage.showAndWait();
		}

//	public void OpenMenu() {
//		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("mainMenu.fxml"));
//		Parent modal;
//		try {
//	
//			modal = fxmlLoader.load();
//			Stage modalStage = new Stage();
//			modalStage.initModality(Modality.APPLICATION_MODAL);
//			modalStage.initOwner(App.rootstage);
//			Scene modalScene = new Scene(modal);
//			modalStage.setScene(modalScene);
//			modalStage.showAndWait();
//			modalStage.show();
//
//		} catch (IOException ex) {
//			Logger.getLogger(logInController.class.getName()).log(Level.SEVERE, null, ex);
//		}
//	}
}
