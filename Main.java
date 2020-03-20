import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.HashMap;

class Main {
    private static Scanner scan;
    private static Map<String, Runnable> menuMap;
    private static boolean isRunning;

    public static void main(String args[]) {
        initialize();

        do{
        scan = new Scanner(System.in);
        scan.useDelimiter(System.lineSeparator());
        mainMenu();
        String userChoice = scan.next();
        menuMap.get(userChoice).run();
        } while (isRunning);
    }

    private static void mainMenu() {
        String[] menuList = { "Add a ToDoItem", "Delete a ToDoItem", "Change status of a ToDoItem",
                "Display ToDoItems by deadline from chosen quarter", "Archieve all done ToDoItems",
                "Export ToDoItems to a .cvs file", "Exit" };
        System.out.println("WELCOME TO EISENHOWER MATRIX");
        System.out.println("");
        System.out.println("TYPE IN NUMBER TO CHOOSE");
        for (int i = 0; i < menuList.length; i++) {
            System.out.println(i + 1 + ". " + menuList[i]);
        }
    }

    private static void exitApp(){
        isRunning = false;
    }

    private static void initialize(){
        isRunning = true;
        menuMap = new HashMap<>();
        menuMap.put("1", () -> addNewItem());
        menuMap.put("7", () -> exitApp());
    }

    private static LocalDate convertStringToLocalDate(String userDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        formatter = formatter.withLocale(Locale.ENGLISH);
        LocalDate date = LocalDate.parse(userDate, formatter);
        return date;
    }

    private static void addNewItem() {
        String itemTitle = gatherInput("Title of your ToDoItem: ");
        String dateString = gatherInput("Deadline of your ToDoItem [DD-MM-YYYY]: ");
        LocalDate formattedDate = convertStringToLocalDate(dateString);
        
        ToDoItem userEvent = new ToDoItem(itemTitle, formattedDate);

        ToDoQuarter quarter = new ToDoQuarter();
        quarter.addItem(userEvent);
        userEvent.getTitle();
        userEvent.getDeadline();
    }

    private static String gatherInput(String title) {
        System.out.println(title);
        String userInput = scan.next();
        return userInput;
    }
}
