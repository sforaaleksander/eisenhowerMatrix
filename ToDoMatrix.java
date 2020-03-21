import java.util.Map;
import java.time.LocalDate;


class ToDoMatrix{
    private Map<String, ToDoQuarter> toDoQuartersMap;

    public ToDoMatrix(){

    }

    public Map<String, ToDoQuarter> getQuarters(){
        return toDoQuartersMap;
    }

    // public ToDoQuarter getQuarter(String priority){
    //     return ToDoQuarter;
    // }

    public void addItem(String title, LocalDate deadline, boolean isImportant){

    }

    public void addItemsFromFile(){

    }

    public void saveItemsToFile(String FileName){

    }

    public void archieveItems(){

    }

    public String toString(){
        return "";
    }


}