module com.proyecto.AbeRol {
	 requires javafx.controls;
	 requires javafx.fxml;
	 requires transitive javafx.graphics;
	 requires java.sql;

    opens com.proyecto.AbeRol to javafx.fxml;
    exports com.proyecto.AbeRol;
}
