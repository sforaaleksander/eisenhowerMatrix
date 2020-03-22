import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

class ToDoQuarter {
    private List<ToDoItem> toDoList;
    private String title;

    public ToDoQuarter(String title) {
        // Constructs a TodoQuarter object with list of TodoItem objects
        toDoList = new ArrayList<>();
        this.title = title;

    }

    public String getTitle(){
        return this.title;
    }

    public void addItem(ToDoItem item) {
        // Append TodoItem object to todoItems sorted decreasing by deadline.
        this.toDoList.add(item);
    }

    public void removeItem(int itemIndex) {
        // Removes TodoItem object using index of list todoItems
        this.toDoList.remove(itemIndex);
    }

    public void removeItemByName(String title) {
        int z = 0;
        for (int i=0;i<this.toDoList.size();i++){
            if (this.toDoList.get(i).getTitle().equals(title)){
                z = i;
            }
        }
    this.toDoList.remove(z);
    }

    public boolean hasItem(String title) {
        for (ToDoItem element : this.toDoList) {
            if (element.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public void archieveItems() {
        for (int i = 0; i < toDoList.size(); i++) {
            if (this.toDoList.get(i).getStatus()) {
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

    public String toString() {
        // Returns a formatted list of todoItems sorted decreasing by deadline. There is
        // an expecting output:
        String output = "";
        int i = 1;
        for (ToDoItem element : this.toDoList){
            output += i++ + ". " + element.toString() + "\n";
        }
        return output;
    }

    public int getNumOfTasks() {
        return this.toDoList.size();
    }
}