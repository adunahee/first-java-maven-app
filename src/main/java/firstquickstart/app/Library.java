package firstquickstart.app;

// import to allows copying of arrays since arrays are fixed length in Java and cannot have new items be pushed onto them
import java.util.Arrays;

public class Library {
    // needs to be set to have length of zero otherwise value is null and incompatible with Arrays methods used on line 17
    Book[] books = new Book[0];
    String address;

    // constructor
    Library(String myAddress) {
        address = myAddress;
    }

    void addBook(Book newBook) {
        books = Arrays.copyOf(books, books.length + 1);
        books[books.length - 1] = newBook;
    }

    static void printOpeningHours() {
        System.out.println("Libraries are open from 9AM to 5PM every day!");
    }

    void printAddress() {
        System.out.println("We are located at " + address);
    }

    void borrowBook(String bookTitle) {
        String borrowStatusUpdate = bookTitle + "is not in our catalogue.";
        for (int i = 0; i < books.length; i++) {
            boolean titleCheck = books[i].getTitle() == bookTitle;
            boolean borrowedCheck = books[i].isBorrowed();
            if (titleCheck && borrowedCheck == false) {
                books[i].borrowed();
                borrowStatusUpdate = bookTitle + "successfully borrowed.";
                break;
            } else if (titleCheck && borrowedCheck == true) {
                borrowStatusUpdate = bookTitle + "is already checked out!";
                break;
            }
        }
        System.out.println(borrowStatusUpdate);
    }

    void printAvailableBooks() {
        for (int i = 0; i < books.length; i++) {
            if (books[i].isBorrowed() == false) {
                System.out.println(books[i].getTitle());
            }
        }
    }

    void returnBook(String bookTitle) {
        for(int i = 0; i < books.length; i++){
            boolean titleCheck = books[i].getTitle() == bookTitle;
            if(titleCheck){
                books[i].returned();
                System.out.println(bookTitle + " successfully returned!");
                break;
            }
        }
    }

    public static void main() {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");
        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));
        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();
        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();
        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();
        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();
        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();
        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}
