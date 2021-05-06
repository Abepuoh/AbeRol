package com.proyecto.AbeRol;

import java.net.URL;
import java.util.ResourceBundle;
import com.proyecto.AbeRol.Model.MasterDAO;

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
		this.colUser.setCellValueFactory(new PropertyValueFactory("name"));
		this.colPassword.setCellValueFactory(new PropertyValueFactory("password"));
	}
	//PROBLEMA MASTER DAO APUNTA A NULL
	@FXML
	public void recover() {
		String email = this.txtEmail.getText();
		if (email.trim().length() > 0) {
			MasterDAO dummy = new MasterDAO();
			ObservableList<MasterDAO> items = dummy.getMasterByEmail(email);
			this.recovery.setItems(items);
		}
	}

	@FXML
	private void exit(ActionEvent event) {
		Stage stage = (Stage) this.buttExit.getScene().getWindow();
		stage.close();

	}
}
