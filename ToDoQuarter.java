import java.util.List;
import java.time.LocalDate;

class ToDoQuarter {
    private List<ToDoItem> toDoList;

    public ToDoQuarter() {
        // Constructs a TodoQuarter object with list of TodoItem objects
    }

    public  void addItem(String title, LocalDate deadline) {
        // Append TodoItem object to todoItems sorted decreasing by deadline.
    }

    public void removeItem(int itemIndex) {
        // Removes TodoItem object using index of list todoItems
    }

    public void archieveItems() {
        // Removes all TodoItem objects with a parameter isDone set to true from list
        // todoItems.
    }

    public void getItems() {
        // Returns TodoItem object from index of list todoItems.
    }

    public void toStringItems(){
        //Returns a formatted list of todoItems sorted decreasing by deadline. There is an expecting output:
    }
}