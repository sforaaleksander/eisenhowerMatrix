import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;


class ToDoMatrix{
    private Map<String, ToDoQuarter> toDoQuartersMap;

    public ToDoMatrix(){
        toDoQuartersMap = new HashMap<>();

    }

    public Map<String, ToDoQuarter> getQuarters(){
        return toDoQuartersMap;
    }

    public ToDoQuarter getQuarter(String priority){
        return this.toDoQuartersMap.get(priority);
    }

    public void addItem(ToDoItem item, boolean isImportant){

    }

    public void addQuarter(String title, ToDoQuarter quarter){
        this.toDoQuartersMap.put(title, quarter);
    }

    public void addItemsFromFile(){

    }

    public void saveItemsToFile(String FileName){
        // this.toDoQuartersMap
    }

    public void archieveItems(){
    }

    public String toString(){
        String output = "";
        for (String key : toDoQuartersMap.keySet()){
            output += key + "\n";
            output += toDoQuartersMap.get(key).toString();
        }
        return output;
    }


}