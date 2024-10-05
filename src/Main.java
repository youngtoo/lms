import java.util.Scanner;

public class Main {

    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    private static final String WELCOME_MESSAGE = "=== Welcome to the Library Management System ===";

    // Main Method
    public static void main(String[] args) {

        boolean exit = false;

        System.out.println(WELCOME_MESSAGE);

        while(!exit){

            printMenu();

            int choice = getUserChoice();
            switch (choice){
                case 1:
                    handleAddBook();
                    break;
                case 2:
                    handleRemoveBook();
                    break;
                case 3:
                    handleSearchBook();
                    break;
                case 4:
                    library.displayAllBooks();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid Choice! Please try again.");
            }
        }
    }

    private static void printMenu(){

        String prompt = "Please choose an option:";
        String menu1 = "1. Add a book.";
        String menu2 = "2. Remove a book.";
        String menu3 = "3. Search for a book.";
        String menu4 = "4. Display all Books.";
        String menu5 = "5. Exit";

        System.out.println(prompt);
        System.out.println(menu1);
        System.out.println(menu2);
        System.out.println(menu3);
        System.out.println(menu4);
        System.out.println(menu5);

    }

    private static int getUserChoice(){
        System.out.println("Enter your choice:");

        //filter the input
        while(!scanner.hasNextInt()){
            System.out.println("Invalid input. Enter a number between 1 and 5:");
            scanner.next();
        }
        return scanner.nextInt();

    }

    // Handle Add book
    private static void handleAddBook(){

    }
    // Handle Remove book
    private static void handleRemoveBook(){

    }
    // Handle search book
    private static void handleSearchBook(){

    }
}
