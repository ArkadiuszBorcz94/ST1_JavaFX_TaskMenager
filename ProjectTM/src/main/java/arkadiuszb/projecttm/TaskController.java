package arkadiuszb.projecttm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
public class TaskController implements Initializable {


    @FXML
    private Button addTask;
    @FXML private Button executeTask;
    @FXML private Button deleteTask;
    @FXML private TableView<Tasks> taskTable;
    @FXML private TableColumn<Tasks,String> idColumn;
    @FXML private TableColumn<Tasks,String>  nameColumn;
    @FXML private TableColumn<Tasks,String>  priorityColumn;

    @FXML private TableColumn<Tasks,String>  statColumn;
    @FXML private TableColumn<Tasks,String>  catColumn;
    @FXML private TableColumn<Tasks, LocalDate>  dateColumn;
    @FXML private TextField nameTaskText;
    @FXML private TextField dateTaskText;

    @FXML private ComboBox<String> categoryBox;
    @FXML private ComboBox<String> priorityBox;
    @FXML private Label dateLabel;



   @FXML
   public void select(ActionEvent event) {


       Object selectedItem = categoryBox.getSelectionModel().getSelectedItem();

       //sprawdzenie czy wartości w combobox są null, by wywołać metodę "toString()"

       String selectedItemString = (selectedItem != null) ? selectedItem.toString() : null;


}



    //inicjalizacja kategorii dla ComboBox
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       String [] items={"Dom", "Praca", "Nauka"};
       categoryBox.getItems().addAll(items);
        String [] priorities={"Wysoki", "Średni", "Niski"};
        priorityBox.getItems().addAll(priorities);
        dateLabel.setText(String.valueOf(java.time.LocalDate.now()).toString());


    }


    int currentId=0;
    //Dodawanie zadań do TableView
    @FXML
    public void addTask(){



            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            priorityColumn.setCellValueFactory(new PropertyValueFactory<>("priority"));
            dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
            catColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
            statColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

         ObservableList<Tasks> tasksList= FXCollections.observableArrayList();
          tasksList.add(new Tasks(currentId,nameTaskText.getText(),priorityBox.getSelectionModel().getSelectedItem().toString(),LocalDate.parse(dateTaskText.getText().toString()),categoryBox.getSelectionModel().getSelectedItem().toString(),"W trakcie"));

            taskTable.getItems().addAll(tasksList);
            clearInputFields();
            currentId++;





    }

   // // metoda czyszcząca wszyskie wypełnione pola
 private void clearInputFields(){
     nameTaskText.clear();;
     priorityBox.getSelectionModel().clearSelection();
     dateTaskText.clear();;
     categoryBox.getSelectionModel().clearSelection();



 }


    //Usuwanie zaznaczonych zadań z TableView
    @FXML
    public void  deleteTask(){

        int selectedTask =taskTable.getSelectionModel().getSelectedIndex();
        if(selectedTask>=0) {
            taskTable.getItems().remove(selectedTask);
        }

    }

//Zmiana statusu zadania jako "Zrealizowane"
    @FXML
        public void  executeTask(){

        int selectedTask=taskTable.getSelectionModel().getSelectedIndex();
        if ( selectedTask>=0){
            taskTable.getItems().get(selectedTask).setStatus("Zrealizowane");

            taskTable.refresh();


        }


    }




}
