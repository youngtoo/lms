import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;
    private int nextId;

    public Library (){
        books = new ArrayList<>();
        nextId = 1;
    }

    // Add a new book
    public void addBook(String title, String author){
        Book book = new Book(nextId++, title, author);
        books.add(book);
        System.out.println("Book added: " + book);
    }

    // Remove book by Id
    public void removeBook(int id){
       Book bookToRemove = findBookById(id);

       if(bookToRemove != null){
           books.remove(bookToRemove);
           System.out.println("Book removed!" + bookToRemove);
       } else {
           System.out.println("Book with ID " + id + " not found!");
       }
    }

    // Search Book by Title
    public void  searchByTitle(String title){
        List<Book> results = new ArrayList<>();

        for(Book book: books){
            if(book.getTitle().toLowerCase().contains(title.toLowerCase())){
                results.add(book);
            }
        }
        displayBooks(results);
    }

    // Display all books
    public void displayAllBooks(){
        displayBooks(books);
    }

    // List books
    public void displayBooks(List<Book> booksToDisplay){
        if(booksToDisplay.isEmpty()){
            System.out.println("No books found");
            return;
        }

        for(Book book: booksToDisplay){
            System.out.println(book);
        }
    }



    // Find book by id
    private Book findBookById(int id){
        for (Book book: books){
            if(book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
