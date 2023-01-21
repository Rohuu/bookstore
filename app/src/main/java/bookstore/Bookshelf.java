package bookstore;

import java.util.HashSet;
import java.util.Set;

public class Bookshelf {
    private Set<Book> books;

    public Bookshelf() {
        this.books = new HashSet<>();
    }

    public int noOfBooks() {
        return this.books.size();
    }

    public void add(Book book) {
        boolean added = this.books.add(book);
        if (!added) {
            throw new IllegalArgumentException("You can't add same book twice");
        }
    }

    public void share() {
    }

    public boolean delete(Book book) {
        return this.books.remove(book);
    }
}
