package library;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class LibraryApp {
    private List<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run(){
        boolean running = true;
        while(running) {
            System.out.println("\nWelcome to Library App!");
            System.out.println("1.Print all books");
            System.out.println("2.Add new book");
            System.out.println("3.Search books by title");
            System.out.println("4.Borrow a book");
            System.out.println("5.Return a book");
            System.out.println("6.Delete a book by id");
            System.out.println("7.Quit");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    printAllBooks();
                    break;
                case "2":
                    addNewBook();
                    break;
                case "3":
                    searchBooksByTitle();
                    break;
                case "4":
                    borrowBook();
                    break;
                case "5":
                    returnBook();
                    break;
                case "6":
                    deleteBookById();
                    break;
                case "7":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice,enter a number between 1 and 7");
            }
        }
    }

    private void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private void addNewBook() {
        try {
            System.out.print("book title: ");
            String title = scanner.nextLine();

            System.out.print("book author: ");
            String author = scanner.nextLine();

            System.out.print("book year: ");
            int year = Integer.parseInt(scanner.nextLine());

            Book newBook = new Book(title, author, year );
            books.add(newBook);
            System.out.println("Book added: " + newBook);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void searchBooksByTitle() {
        System.out.print("Enter the title: ");
        String query = scanner.nextLine().toLowerCase();

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query)) {
                System.out.println(book);
            }
        }
    }

    private void borrowBook() {
        System.out.print("Enter book ID to borrow: ");
        int id = Integer.parseInt(scanner.nextLine());
        Book book = findBookById(id);
        if (book != null) {
            if (book.isAvailable()) {
                book.markAsBorrowed();
                System.out.println("Book borrowed successfully: " + book.getTitle());
            } else {
                System.out.println("The book is already borrowed.");
            }
        }

    }

    private void returnBook() {
        System.out.print("Enter book ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Book book = findBookById(id);
        if (book != null) {
            if (!book.isAvailable()) {
                book.markAsReturned();
                System.out.println("Book returned successfully: " + book.getTitle());
            }
        }
    }


    private void deleteBookById() {
        System.out.print("Enter book ID : ");
        int id = Integer.parseInt(scanner.nextLine());
        Book book = findBookById(id);
        if (book != null) {
            books.remove(book);
            System.out.println("Book deleted: " + book.getTitle());
        } else {
            System.out.println("Book not found with ID: " + id);
        }
    }


    private Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) return book;
        }
        return null;
    }

    public static void main(String[] args) {
        LibraryApp app = new LibraryApp();
        app.run();
    }
}