module com.jsltd.corsser {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.jsltd.corsser to javafx.fxml;
    exports com.jsltd.corsser;
    exports com.jsltd.corsser.dataBase;
    opens com.jsltd.corsser.dataBase to javafx.fxml;
}