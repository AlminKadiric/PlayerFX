module com.lines.connected.playerfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires transitive javafx.base;
    requires transitive javafx.graphics;




    opens com.lines.connected.playerfx to javafx.fxml;
    opens com.lines.connected.playerfx.dao.entity to javafx.base;
    exports com.lines.connected.playerfx;
}