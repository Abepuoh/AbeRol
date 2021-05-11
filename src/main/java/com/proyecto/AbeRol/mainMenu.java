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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
	private ChoiceBox <Player> choosePlayer;

	@FXML
	private GridPane gridPlayer;
	
	@FXML
	private GridPane gridDescripcion;
	
	@FXML
	private Label name;
	@FXML
	private Label level;
	@FXML
	private Label strength;
	@FXML
	private Label dexerity;
	@FXML
	private Label intelligence;
	@FXML
	private Label height;
	@FXML
	private Label weigth;
	@FXML
	private Label pclass;
	@FXML
	private Label age;
	@FXML
	private Label info;
	
	MasterDAO user = new MasterDAO();
	
	@FXML
	public void initialize() {
		MasterSingleton transfer =MasterSingleton.getInstance();
		user = transfer.getUser();
		this.choiceRol.setItems(user.getRol());
		gridPlayer.setGridLinesVisible(true);
		RolDAO u = new RolDAO(1);
		this.choosePlayer.setItems(u.getPlayer());
		PlayerDAO p = new PlayerDAO(1);
		name.setText(p.getName().toString());
		level.setText(p.getLevel()+"".toString());
		strength.setText(p.getStrength()+"".toString());
		dexerity.setText(p.getDexerity()+"".toString());
		intelligence.setText(p.getIntelligence()+"".toString());
		height.setText(p.getHeight()+"".toString());
		weigth.setText(p.getWeight()+"".toString());
		pclass.setText(p.getClassRol().toString());
		age.setText(p.getAge()+"".toString());
		info.setText(p.getInformation().toString());
		
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
