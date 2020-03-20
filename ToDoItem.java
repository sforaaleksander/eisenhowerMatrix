import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class ToDoItem{
    private String title;
    private LocalDate deadline;
    private boolean isDone;


    public ToDoItem(String title, LocalDate deadline){
        this.title = title;
        this.deadline = deadline;
        isDone = false;
    }

    public String getTitle(){
        return this.title;
    }

    public LocalDate getDeadline(){
        return this.deadline;
    }

    public boolean getStatus(){
        return this.isDone;
    }

    public void mark(){
        this.isDone = true;
        System.out.println("ToDoItem marked as done.");
    }

    public void unmark(){
        this.isDone = false;
        System.out.println("ToDoItem marked as undone.");
    }

    public String itemToString(){
        String entry = "";

        if (this.isDone){
            entry += "[x]";
        } else{
            entry += "[ ]";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String deadlineString = formatter.format(this.deadline);
        entry += deadlineString + " " + this.title;
        return entry;
    }
}