module arkadiuszb.projecttm {
    requires javafx.controls;
    requires javafx.fxml;


    opens arkadiuszb.projecttm to javafx.fxml;
    exports arkadiuszb.projecttm;
}