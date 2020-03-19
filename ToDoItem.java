import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class ToDoItem{
    private String title;
    private LocalDate deadline;
    private boolean isDone;


    public ToDoItem(String titleArg, LocalDate deadlineArg){
        // constructor
        title = titleArg;
        deadline = deadlineArg;
        isDone = false;
    }

    public void getTitle(){
        System.out.println(this.title);
    }

    public void getDeadline(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println(formatter.format(this.deadline));
    }

    public void mark(){
        this.isDone = true;
        System.out.println("ToDoItem marked as done.");
    }

    public void unmark(){
        this.isDone = false;
        System.out.println("ToDoItem marked as undone.");
    }

    public void itemToString(){
    }
}