public class BookNotAvailableException extends Exception {

    public BookNotAvailableException(Book book)  {
        super("Book \"" + book.getTitle() + "\" is already borrowed: " + book.isBorrowed());
    }
}
