package com.proyecto.AbeRol;

import java.net.URL;
import java.util.ResourceBundle;
import com.proyecto.AbeRol.Model.MasterDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class recovery {

	@FXML
	private TextField txtEmail;
	@FXML
	private Button buttRecovery;
	@FXML
	private TableView<MasterDAO> recovery;
	@FXML
	private TableColumn<MasterDAO, String> colUser;
	@FXML
	private TableColumn<MasterDAO, String> colPassword;
	@FXML
	private Button buttExit;
	
	
	@FXML
	public void initialize(URL url, ResourceBundle rb) {
	
	}

	@FXML
	public void recover() {
		this.colUser.setCellValueFactory(new PropertyValueFactory<MasterDAO, String>("name"));
		this.colPassword.setCellValueFactory(new PropertyValueFactory<MasterDAO, String>("password"));
		
		String email = this.txtEmail.getText();
		if (email.trim().length() > 0) {
			MasterDAO dummy = new MasterDAO(email);
			ObservableList<MasterDAO> items = FXCollections.observableArrayList(dummy);
			this.recovery.setItems(items);
		}
	}

	@FXML
	private void exit(ActionEvent event) {
		Stage stage = (Stage) this.buttExit.getScene().getWindow();
		stage.close();

	}
}
