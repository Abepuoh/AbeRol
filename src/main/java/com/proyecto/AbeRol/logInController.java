package com.proyecto.AbeRol;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.proyecto.AbeRol.Model.Master;

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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class logInController {
	@FXML
	private AnchorPane rootPane;
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

	private static Scene scene;

	@FXML
	public void initialize(URL url, ResourceBundle rb) {
	}

	@FXML
	protected void logUser(ActionEvent Event) throws IOException {
		AnchorPane pane=FXMLLoader.load(App.class.getResource("menu.fxml"));
		rootPane.getChildren().setAll(pane);
//		String name = this.txtUser.getText();
//		String password = this.txtPass.getText();
//		Master dummy = new Master(name, password);
//		// CHECK
//		if (!masters.contains(dummy) && dummy.getPassword() == password && dummy.getName() == name) {
//			Alert alert = new Alert(Alert.AlertType.INFORMATION);
//			alert.setHeaderText(null);
//			alert.setTitle("Informacion");
//			alert.setContentText("Has entrado correctamente");
//			alert.showAndWait();
//			// CARGO VENTAN
//		} else {
//			Alert alert = new Alert(Alert.AlertType.ERROR);
//			alert.setHeaderText(null);
//			alert.setTitle("Error");
//			alert.setContentText("Has introducido mal algun dato");
//			alert.showAndWait();
//		}
	}

	@FXML
	protected void addMaster(ActionEvent Event) throws IOException {
		AnchorPane pane=FXMLLoader.load(App.class.getResource("signUp.fxml"));
		rootPane.getChildren().setAll(pane);
//		Parent root = loader.load();
//		SignUpController controlador = loader.getController();
//	//	controlador.initAttributtes(masters);
//
//		Scene scene = new Scene(root);
//		Stage stage = new Stage();
//		stage.initModality(Modality.APPLICATION_MODAL);
//		stage.setScene(scene);
//		stage.showAndWait();
//
//		Master dummy = controlador.getMaster();
//		if (dummy != null) {
//			this.masters.add(dummy);
//
//		}
	}
	
	@FXML
	protected void recoveryMaster(ActionEvent Event) throws IOException {
		AnchorPane pane=FXMLLoader.load(App.class.getResource("recovery.fxml"));
		rootPane.getChildren().setAll(pane);
	}

}
