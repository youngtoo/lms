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
        scanner.nextLine();

        System.out.println("Enter book title:");
        String title = scanner.nextLine().trim();

        System.out.println("Enter book author:");
        String author = scanner.nextLine().trim();

        // Run checks
        if (title.isEmpty() || author.isEmpty()){
            System.out.println("Title and/or author cannot be empty.");
            return;
        }

        // Add the book
        library.addBook(title, author);
    }
    // Handle Remove book
    private static void handleRemoveBook(){
        System.out.println("Enter the ID of the book to remove:");
        while(!scanner.hasNextInt()){
            System.out.println("Invalid input. Enter a valid book ID.");
            scanner.next();
        }

        int id = scanner.nextInt();
        library.removeBook(id);
    }
    // Handle search book
    private static void handleSearchBook(){
        scanner.nextLine();

        // Prompt the user on them method of search
        System.out.println("Search by: ");
        System.out.println("1. Title");
        System.out.println("2. Author");
        System.out.println("Enter your choice: ");

        int searchChoice = getUserChoice();
        switch (searchChoice){
            case 1:
                System.out.println("Enter title to search: ");
                String title = scanner.nextLine().trim();
                library.searchByTitle(title);
                break;
            case 2:
                System.out.println("Enter Author to search: ");
                String author = scanner.nextLine().trim();
                library.searchByAuthor(author);
                break;
            default:
                System.out.println("Invalid Choice!");
        }
    }
}
