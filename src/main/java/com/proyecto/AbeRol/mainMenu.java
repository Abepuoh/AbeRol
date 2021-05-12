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
	private ComboBox<Player> choosePlayer;
	
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
		MasterSingleton transfer = MasterSingleton.getInstance();
		user = transfer.getUser();
		gridPlayer.setGridLinesVisible(true);
		this.choiceRol.setItems(user.getRol());

	}
	@FXML
	protected void choose(ActionEvent Event) throws IOException {
		RolDAO rol = new RolDAO(this.choiceRol.getValue().toString());
		
		this.choosePlayer.setItems(rol.getPlayer());
	
	}
	@FXML
	protected void fillGrid(ActionEvent Event) throws IOException {
		PlayerDAO player = new PlayerDAO(this.choosePlayer.getValue());
		
		name.setText(player.getName().toString());
		level.setText(player.getLevel() + "".toString());
		strength.setText(player.getStrength() + "".toString());
		dexerity.setText(player.getDexerity() + "".toString());
		intelligence.setText(player.getIntelligence() + "".toString());
		height.setText(player.getHeight() + "".toString());
		weigth.setText(player.getWeight() + "".toString());
		pclass.setText(player.getClassRol().toString());
		age.setText(player.getAge() + "".toString());
		info.setText(player.getInformation());
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
