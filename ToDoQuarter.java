import java.util.ArrayList;
import java.util.List;

class ToDoQuarter {
    private List<ToDoItem> toDoList;

    public ToDoQuarter() {
        toDoList = new ArrayList<>();
    }

    public void addItem(ToDoItem item) {
        this.toDoList.add(item);
    }

    public void removeItem(int itemIndex) {
        this.toDoList.remove(itemIndex);
    }

    public void removeItemByName(String title) {
        int z = 0;
        for (int i = 0; i < this.toDoList.size(); i++) {
            if (this.toDoList.get(i).getTitle().equals(title)) {
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
        return this.toDoList.get(index);
    }

    public List<ToDoItem> getItems() {
        return this.toDoList;
    }

    public String toString() {
        String output = "";
        int i = 1;
        for (ToDoItem element : this.toDoList) {
            output += i++ + ". " + element.toString() + "\n";
        }
        return output;
    }

    public int getNumOfTasks() {
        return this.toDoList.size();
    }
}