package arkadiuszb.projecttm;

import java.time.LocalDate;
import arkadiuszb.projecttm.Tasks;

public class Tasks {
    int id=0;
    String name=null;
    String priority=null;
    LocalDate date=null;
    String category=null;
    String status=null;


    public String getCategory() {return category;}

    public void setCategory(String category) {this.category = category;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Tasks(Integer id, String name, String priority, LocalDate date,String category,String status) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.date = date;
        this.category=category;
        this.status = status;
    }


}
