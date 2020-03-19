import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Main {
    private static Scanner scan;

    public static void main(String args[]) {
        scan = new Scanner(System.in);
        scan.useDelimiter(System.lineSeparator());
        mainMenu();
        userMenuChoice();
    }

    private static void mainMenu() {
        String[] menuList = { "Add a ToDoItem", "Delete a ToDoItem", "Change status of a ToDoItem",
                "Display ToDoItems by deadline from chosen quarter", "Archieve all done ToDoItems",
                "Export ToDoItems to a .cvs file" };
        System.out.println("WELCOME TO EISENHOWER MATRIX");
        System.out.println("");
        System.out.println("TYPE NUMBER TO MOVE AROUND MENU.");
        for (int i = 0; i < menuList.length; i++) {
            System.out.println(i + 1 + ". " + menuList[i]);
        }
    }

    private static void userMenuChoice() {
        int userChoice = scan.nextInt();
        // int userChoice = 1;
        switch (userChoice) {
            case 1:
                addNewItem();
        }
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
        userEvent.getTitle();
        userEvent.getDeadline();
    }

    private static String gatherInput(String title) {
        System.out.println(title);
        String userInput = scan.next();
        return userInput;
    }
}
