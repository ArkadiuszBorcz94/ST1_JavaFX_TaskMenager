package arkadiuszb.projecttm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class TaskMenager extends Application {
    @Override
    public void start(Stage stage) throws IOException {





        FXMLLoader fxmlLoader = new FXMLLoader(TaskMenager.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("YourTaskMenager");
        stage.setScene(scene);
        stage.show();

    }




    public static void main(String[] args) {
        launch();
    }
}