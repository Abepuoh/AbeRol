module com.proyecto.AbeRol {
	 requires javafx.controls;
	 requires javafx.fxml;
	 requires transitive javafx.graphics;
	 requires java.sql;
	 requires java.xml;
	requires javafx.base;

    opens com.proyecto.AbeRol to javafx.fxml;
    exports com.proyecto.AbeRol;
}
