import java.util.Locale;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Main {
    private static Scanner scan;
    private static Map<String, Runnable> menuMap;
    private static boolean isRunning;
    private static ToDoQuarter UI;
    private static ToDoQuarter XI;
    private static ToDoQuarter UX;
    private static ToDoQuarter XX;
    private static List<List<ToDoItem>> quartersLists;
    private static List<ToDoQuarter> quartersObjects;
    private static ToDoMatrix matrix;

    public static void main(String args[]) {
        initialize();

        do {
            scan = new Scanner(System.in);
            scan.useDelimiter(System.lineSeparator());
            mainMenu();
            String userChoice = scan.next();
            menuMap.get(userChoice).run();
        } while (isRunning);
    }

    private static void mainMenu() {
        String[] menuList = { "Add a ToDoItem", "Delete a ToDoItem", "Change status of a ToDoItem",
                "Display all ToDoItems", "Archive all done ToDoItems", "Export ToDoItems to a .cvs file", "Import ToDoItems from a .csv file", "Exit" };
        System.out.println("");
        System.out.println("EISENHOWER MATRIX");
        System.out.println("");
        System.out.println("TYPE IN NUMBER TO CHOOSE");
        for (int i = 0; i < menuList.length; i++) {
            System.out.println(i + 1 + ". " + menuList[i]);
        }
    }

    private static void exitApp() {
        isRunning = false;
    }

    private static void initialize() {
        isRunning = true;
        createQuartersAndMatrix();
        menuMap = new HashMap<>();
        menuMap.put("1", () -> addNewItem());
        menuMap.put("2", () -> removeItem());
        menuMap.put("3", () -> changeStatusOfItem());
        menuMap.put("4", () -> printAllItems());
        menuMap.put("6", () -> exportToTxt());
       
        menuMap.put("8", () -> exitApp());
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
        String isImportantString = gatherInput("Is your ToDoItem important? [Y/N]");
        LocalDate formattedDate = convertStringToLocalDate(dateString);
        ToDoItem userEvent = new ToDoItem(itemTitle, formattedDate);
        addToQuarter(userEvent, formattedDate, isImportantString);
    }

    private static String gatherInput(String title) {
        System.out.println(title);
        String userInput = scan.next().toUpperCase();
        return userInput;
    }

    private static void createQuartersAndMatrix() {
        UI = new ToDoQuarter("UI");
        XI = new ToDoQuarter("XI");
        UX = new ToDoQuarter("UX");
        XX = new ToDoQuarter("XX");
        quartersLists = Arrays.asList(UI.getItems(), UX.getItems(), XI.getItems(), XX.getItems());
        quartersObjects = new ArrayList<ToDoQuarter>(Arrays.asList(UI, UX, XI, XX));
        matrix = new ToDoMatrix();
    }

    private static boolean isUrgent(LocalDate deadline) {
        if ((deadline.minusDays(3).compareTo(LocalDate.now()) < 0)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean toBoolean(String yesOrNo) {
        if (yesOrNo.equals("Y")) {
            return true;
        } else
            return false;
    }

    private static void addToQuarter(ToDoItem userItem, LocalDate deadline, String isImportant) {
        if (isUrgent(deadline) && toBoolean(isImportant)) {
            UI.addItem(userItem);
            // System.out.println(UI.getItem(0).toString());
            // System.out.println(UI.getNumOfTasks());
        } else if (!isUrgent(deadline) && toBoolean(isImportant)) {
            XI.addItem(userItem);
        } else if (isUrgent(deadline) && !toBoolean(isImportant)) {
            UX.addItem(userItem);
        } else
            XX.addItem(userItem);
    }

    public static List<ToDoItem> listAllItems() {
        List<ToDoItem> allItems = new ArrayList<>();
        for (List<ToDoItem> quarterList : quartersLists) {
            for (ToDoItem element : quarterList) {
                allItems.add(element);
            }
        }
        return allItems;
    }

    public static void printAllItems() {
        int i = 1;
        for (ToDoItem item : listAllItems()) {
            System.out.println(i + ". " + item.toString());
            i++;
        }
    }

    public static void changeStatusOfItem() {
        printAllItems();
        String userItem = gatherInput("Type in the name of ToDoItem you want to edit");
        for (ToDoItem element : listAllItems()) {
            if (element.getTitle().equals(userItem)) {
                if (element.getStatus()) {
                    element.unmark();
                } else
                    element.mark();
            }
        }
    }

    public static void removeItem() {
        printAllItems();
        String userItem = gatherInput("Type in the name of ToDoItem you want to delete");
        for (ToDoQuarter quarter : quartersObjects) {
            if (quarter.hasItem(userItem)) {
                quarter.removeItemByName(userItem);
            }
        }
    }

    public static void archiveAll(){
        for (ToDoQuarter element : quartersObjects){
            element.archieveItems();
        }
    }

    public static String prepareStringToExport(){
        String allEntries = "";
        for (ToDoQuarter quarter : quartersObjects){
            if (quarter.getTitle().equals("UI") || quarter.getTitle().equals("XI")){
                for (ToDoItem item : quarter.getItems()){
                allEntries += item.toFile() + "| is_important\n";
                }
            } else {
                for (ToDoItem item : quarter.getItems()) {
                    allEntries += item.toFile() + " \n";
                }
            }
        }
    return allEntries;
    }

    public static void exportToTxt(){
        String data = prepareStringToExport();
        try {
        File file = new File("ToDoItems.txt");
        FileWriter writer = new FileWriter(file, true);
        writer.write(data);
        writer.close();
        } catch (IOException e){
            System.out.println(e);
        }
    }

}

// public static void changeStatusOfItem(){
// int index = scan.nextInt();
// index -= 1;
// if (index < UI.getNumOfTasks()-1){
// UI.getItem(index).mark();
// } else if (index < (UI.getNumOfTasks() + UX.getNumOfTasks())){
// UX.getItem(index).mark();
// } else if (index < (UI.getNumOfTasks() + UX.getNumOfTasks() +
// XI.getNumOfTasks())){
// XI.getItem(index).mark();
// } else XX.getItem(index).mark();
// }

// public static void changeStatusOfItem(){
// printAllItems();
// System.out.println("Type ToDoItem's index you want status to change");
// }

// private static String decidePriority(LocalDate deadline, String isImportant){
// String priority = "";
// if ((deadline.minusDays(3).compareTo(LocalDate.now()) > 0)){
// priority += "U";
// } else {
// priority += "X";
// }
// switch (isImportant){
// case "Y":
// priority += "I";
// case "N":
// priority += "X";
// }
// return priority;
// }
