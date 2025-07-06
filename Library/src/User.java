import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    private final List<Book> borrowedBooks = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public void borrowBook(Book book) {
        if(!book.isBorrowed()) {
            book.borrow();
            borrowedBooks.add(book);
        }

    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

}
