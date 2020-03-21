import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

class ToDoQuarter {
    private List<ToDoItem> toDoList = new ArrayList<>();

    public ToDoQuarter() {
        // Constructs a TodoQuarter object with list of TodoItem objects
    }

    public void addItem(ToDoItem item) {
        // Append TodoItem object to todoItems sorted decreasing by deadline.
        this.toDoList.add(item);
    }

    public void removeItem(int itemIndex) {
        // Removes TodoItem object using index of list todoItems
        this.toDoList.remove(itemIndex);
    }

    public void archieveItems() {
        for (int i=0; i<toDoList.size(); i++){
            if (this.toDoList.get(i).getStatus()){
                this.toDoList.remove(i);
            }
        }
    }
    

    public ToDoItem getItem(int index) {
        // Returns TodoItem object from index of list todoItems.
        return this.toDoList.get(index);
    }

    public List<ToDoItem> getItems() {
        // Returns private field todoItems.
        return this.toDoList;
    }

    public void toStringItems(){
        //Returns a formatted list of todoItems sorted decreasing by deadline. There is an expecting output:
    }

    public int getNumOfTasks(){
        return this.toDoList.size();
    }
}