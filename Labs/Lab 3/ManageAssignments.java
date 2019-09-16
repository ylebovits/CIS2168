import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class ManageAssignments {

    private static Scanner keyboard = new Scanner(System.in);
    
    public static void main(String[] args) {
        LinkedList<Assignment> assignments = new LinkedList<>();

        boolean menuFlag = true; // whether or not user wants to keep using the program
        int selection;

        do {
            printMenu();
            selection = getOption();
            if (selection == 6)
                menuFlag = false;

            callMethods(assignments, selection);

        } while (menuFlag);
        
    }

    // display a list of options to the user
    private static void printMenu() {
        System.out.println("\n- - - - - - - - -\nOptions:\n1 - add assignment\n2 - remove assignment\n3 - remove all assignments\n4 - print soonest due assignment\n5 - print all assignments\n6 - exit program");
    }

    // prompt user to select from menu
    private static int getOption() {
        int option = 0;

        do {
            System.out.print("Enter selection (1-6): ");
            option = keyboard.nextInt();
            keyboard.nextLine();
        } while (option < 1 || option > 6);

        return option;

    }

    // call other methods based on user selected option
    private static void callMethods(LinkedList<Assignment> L, int option) {

        switch (option) {
            case 1:
                addAssign(L);
                break;

            case 2:
                rmAssign(L);
                break;

            case 3:
                L.clear();
                break;

            case 4:
                printSoonestDue(L);
                break;

            case 5:
                printAll(L);
                break;

            default:
                break;
        }
    }

    // take input from the user, create an assignment, and add it to the linkedlist
    private static void addAssign(LinkedList<Assignment> L) {
        String courseID;
        String tmpDate; // temporarily hold date as a string
        Date date = null; // by default
        String assignmentName;

        System.out.print("Enter the course ID: ");
        courseID = keyboard.nextLine();

        System.out.print("Enter the date (mm/dd/yyyy): ");
        tmpDate = keyboard.nextLine();
        try {
            date = new SimpleDateFormat("MM/dd/yyyy").parse(tmpDate); // convert string date into Date type
        } catch (java.text.ParseException e) { // assume good input and ignore error
            ;
        }

        System.out.print("Enter the assignment name: ");
        assignmentName = keyboard.nextLine();

        Assignment A = new Assignment(courseID, assignmentName, date);
        L.add(A);
    }

    // take a name from user, and remove the assignment with a matching name
    private static void rmAssign(LinkedList<Assignment> L) {
        String assignmentName;

        System.out.print("Enter the assignment name to remove (case sensitive): ");
        assignmentName = keyboard.nextLine();

        // delete the first list item with a matching name
        for (Assignment A : L) {
            if (assignmentName.equals(A.getAssignmentName())) {
                L.remove(A);
                break;
            }
        }

    }

    // print the assignment with the earliest due date
    private static void printSoonestDue(LinkedList<Assignment> L) {
        Assignment minDate = L.get(0); // set initial earliest due to the first assignment

        // iterate over list and find earliest due date
        for (Assignment A : L)
            if (A.getDueDate().before(minDate.getDueDate()))
                minDate = A;

        System.out.print(minDate);
    }

    // print every Assignment in the list
    private static void printAll(LinkedList<Assignment> L) {
        if (L.size() == 0)
            System.out.println("No assignments!");

        System.out.println("\n- - - - - - - - -");
        for (Assignment A : L) {
            System.out.print(A);
        }
    }
}
