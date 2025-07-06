import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> borrowedBooks;
    List<Book> allBooks;
    List<Book> listAvailableBooks;

    public Library() {
        allBooks = new ArrayList<Book>();
        borrowedBooks = new ArrayList<>();
    }
    public void addBook(Book book) {
        allBooks.add(book);
    }

    public Book getBook(String isbn) {
        for (Book book : allBooks) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(String isbn, User user) throws BookNotAvailableException {
        Book book = getBook(isbn);
        if (book == null) {
            System.out.println("Book not found");
        }
        else if (book.isBorrowed() || !allBooks.contains(book)) {
            throw new BookNotAvailableException(book);
        } else {
            user.borrowBook(book);
            borrowedBooks.add(book);
        }
    }

    public void returnBook(String isbn, User user) {
        Book book = getBook(isbn);
        if (book != null) {
            user.returnBook(book);
            borrowedBooks.remove(book);
        } else {
            System.out.println("Book not found");
        }
    }

    public List<Book> getListAvailableBooks() {
        listAvailableBooks = new ArrayList<>(allBooks);
        listAvailableBooks.removeAll(borrowedBooks);
        return listAvailableBooks;
    }

    public List<Book> getAllBooks() {
        return allBooks;
    }
}
