module com.proyecto.AbeRol {
	 requires javafx.controls;
	 requires javafx.fxml;
	 requires transitive javafx.graphics;
	 requires java.sql;
	 requires java.xml;
	 requires javafx.base;

    opens com.proyecto.AbeRol to javafx.fxml;
    opens com.proyecto.AbeRol.Model to javafx.base;
    exports com.proyecto.AbeRol;
}
