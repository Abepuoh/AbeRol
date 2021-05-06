package com.proyecto.AbeRol;

import java.net.URL;
import java.util.ResourceBundle;

import com.proyecto.AbeRol.Model.Master;
import com.proyecto.AbeRol.Model.MasterDAO;

import controlador.ObservableList;
import controlador.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import modelo.Servicio;

public class recovery {

	@FXML
	private TextField txtEmail;
	@FXML
	private Button buttRecovery;
	@FXML 
	private TableView<Master> recovery;
	@FXML
	private TableColumn<Master,String>colUser;
	@FXML
	private TableColumn<Master,String>colPassword;
	@FXML
	private Button buttExit;

	private Stage myStage;
	
	@FXML
	public void initialize(URL url, ResourceBundle rb) {
		this.colUser.setCellValueFactory(new Master("Usuario"));
        this.colPassword.setCellValueFactory(new Master("Contrseña"));
        
        MasterDAO dummy = new Master();
        ObservableList<Master> items = dummy.getServicios();
        this.tblServicios.setItems(items);
	}

	@FXML
	public void recover() {
		String email = this.txtEmail.getText();	
		MasterDAO dummy = new MasterDAO();
		dummy.getMasterByEmail(email);
		Master aux = dummy;
		if (aux != null) {
			this.labelUser=aux.getName();
						  =aux.getPassword();
			
		}
	
	}
	@FXML
    private void exit(ActionEvent event) {
        Stage stage = (Stage) this.buttExit.getScene().getWindow();
        stage.close();
 
    }
}
