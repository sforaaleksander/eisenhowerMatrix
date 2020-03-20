import java.util.List;
import java.time.LocalDate;

class ToDoQuarter {
    private List<ToDoItem> toDoList;

    public ToDoQuarter() {
        // Constructs a TodoQuarter object with list of TodoItem objects

    }

    public void addItem(ToDoItem item) {
        // Append TodoItem object to todoItems sorted decreasing by deadline.
        toDoList.add(item);
    }

    public void removeItem(int itemIndex) {
        // Removes TodoItem object using index of list todoItems
        toDoList.remove(itemIndex);
    }

    public void archieveItems() {
        for (int i=0; i<toDoList.size(); i++){
            if (toDoList.get(i).getStatus()){

            }
        }
        }
    

    public void getItem(int index) {
        // Returns TodoItem object from index of list todoItems.
    }

    public void getItems() {
        // Returns TodoItem object from index of list todoItems.
    }

    public void toStringItems(){
        //Returns a formatted list of todoItems sorted decreasing by deadline. There is an expecting output:
    }
}