package com.proyecto.AbeRol;

import java.io.IOException;

import com.proyecto.AbeRol.UIUtils.AudioFilePlayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	private static Scene scene;
	public static Stage rootstage;
	static AudioFilePlayer a;

	@Override
	public void start(Stage stage) throws IOException {
		a = new AudioFilePlayer();
		a.start();
		scene = new Scene(loadFXML("login"), 700, 500);
		stage.setScene(scene);
		stage.getIcons().add(new Image(App.class.getResourceAsStream("logo.png")));
		stage.setResizable(false);
		stage.show();

	}

	public static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	public static void main(String[] args) {
		launch();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void stop() {
		a.stop();
	}

}