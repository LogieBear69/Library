//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        User Logan = new User("Logan");

        library.addBook(new Book("The Martian", "Andy Weir", "97805533418026"));
        library.addBook(new Book("A Brief History of Time", "Stephen Hawking", "9788420639710"));

        try {
            library.borrowBook("97805533418026", Logan);
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nAvailable Books:");
        System.out.println(library.getListAvailableBooks());


        library.returnBook("97805533418026", Logan);
        System.out.println("\nAll Books:");
        System.out.println(library.getAllBooks());


    }
}