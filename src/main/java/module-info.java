module com.proyecto.AbeRol {
	 requires javafx.controls;
	 requires javafx.fxml;
	 requires transitive javafx.graphics;
	 requires java.sql;
	 requires java.xml;
	 requires javafx.base;
	 requires javafx.media;
 	requires java.desktop;

    opens com.proyecto.AbeRol to javafx.fxml,javafx.media,javafx.base;
    opens com.proyecto.AbeRol.Model to javafx.base,javafx.fxml;
    exports com.proyecto.AbeRol;
    exports com.proyecto.AbeRol.Model;
}
