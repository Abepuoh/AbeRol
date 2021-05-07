package com.proyecto.AbeRol;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;


import com.proyecto.AbeRol.Model.AudioFilePlayer;
import com.proyecto.AbeRol.Model.MasterDAO;
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
	
	private Stage myStage;
	
	@FXML
	public void initialize() {
		
	}
	
	
	@FXML
	protected void logUser(ActionEvent Event) throws IOException {
		String name = this.txtUser.getText();
		String password = this.txtPass.getText();
		MasterDAO root = new MasterDAO();
		this.txtUser.clear();
		this.txtPass.clear();
		if (root.logIn(name, password) == true) {
			OpenMenu();
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
		modalStage.setResizable(false);
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
		modalStage.setResizable(false);
	}
	
	@FXML
	public void getParameter(String auxMaster) {
		txtUser.setText(auxMaster);
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
			modalStage.setResizable(false);

		} catch (IOException ex) {
			Logger.getLogger(logInController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
