package com.proyecto.AbeRol;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.proyecto.AbeRol.Model.MasterDAO;
import com.proyecto.AbeRol.Model.MasterSingleton;
import com.proyecto.AbeRol.Model.Player;
import com.proyecto.AbeRol.Model.PlayerDAO;
import com.proyecto.AbeRol.Model.Rol;
import com.proyecto.AbeRol.Model.RolDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class mainMenu {

	@FXML
	private Button buttEditMaster;

	@FXML
	private Button buttEditRol;

	@FXML
	private Button buttEditPlayer;

	@FXML
	private Button buttExit;

	@FXML
	private ComboBox<Rol> choiceRol;

	@FXML
	ComboBox<Player> choosePlayer;
	
	@FXML 
	private Label P1Name;
	@FXML 
	private Label P1Level;
	@FXML 
	private Label P1Strength;
	@FXML 
	private Label P1Dexerity;
	@FXML 
	private Label P1Intelligence;
	@FXML 
	private Label P1Height;
	@FXML 
	private Label P1Weigth;
	@FXML 
	private Label P1Class;
	@FXML 
	private Label P1Age;
	@FXML	
	private Label P1Description;
	
	@FXML
	private GridPane gridPlayer;

	MasterDAO user = new MasterDAO();
	
	PlayerDAO grid = new PlayerDAO(1);
	
	@FXML
	public void initialize() {
		MasterSingleton transfer = MasterSingleton.getInstance();
		user = transfer.getUser();
		this.choiceRol.setItems(user.getRol());
		//Rol data = this.choiceRol.getSelectionModel().getSelectedItem();
		
//		RolDAO value = new RolDAO(1);
//		System.out.println(value.getId());
//		this.choosePlayer.setItems(value.getPlayer());
//		gridPlayer.setGridLinesVisible(true);

		GridPane.setConstraints(P1Name, 1,0);
		GridPane.setConstraints(P1Level, 1,1);
		GridPane.setConstraints(P1Strength, 1,2);
		GridPane.setConstraints(P1Dexerity, 1,3);
		GridPane.setConstraints(P1Intelligence, 1,4);
		GridPane.setConstraints(P1Height, 1,5);
		GridPane.setConstraints(P1Weigth, 1,6);
		GridPane.setConstraints(P1Class, 1,7);
		GridPane.setConstraints(P1Age, 1,8);
	}
	
	@FXML
	protected void editMaster(ActionEvent Event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("editMaster.fxml"));
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
			Logger.getLogger(mainMenu.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@FXML
	protected void editRol(ActionEvent Event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("editRol.fxml"));
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
			Logger.getLogger(mainMenu.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@FXML
	protected void EditPlayer(ActionEvent Event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("playerController.fxml"));
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
			Logger.getLogger(mainMenu.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@FXML
	private void exit(ActionEvent event) {
	
		Stage stage = (Stage) this.buttExit.getScene().getWindow();
		stage.close();
	}

}
