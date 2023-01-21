package bookstore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bookshelf {
    private Set<Book> books;
    private boolean visible;

    public Bookshelf() {
        this(false);
    }

    public Bookshelf(boolean visible) {
        this.visible = visible;
        this.books = new HashSet<>();
    }

    public int noOfBooks() {
        return this.books.size();
    }

    public void add(Book book) {
        // Varargs
        /*
         * public void add(Book... books) -> so that we dont have to call add multiple
         * times
         */

        boolean added = this.books.add(book);
        if (!added) {
            throw new IllegalArgumentException("You can't add same book twice");
        }
    }

    public boolean share(String sharingType, String toEmail) {
        if (isNotVisible()) {
            throw new IllegalStateException("You can't share private bookshelf");
        }
        if (sharingType == "email") {
            sendEmail(toEmail);
            return true;
        }
        return false;
    }

    private void sendEmail(String toEmail) {
        System.out.println("Send email to " + toEmail);
    }

    private boolean isNotVisible() {
        return !this.visible;
    }

    public boolean delete(Book book) {
        return this.books.remove(book);
    }

    public List<Book> listBooks() {
        List<Book> sortedBooks = new ArrayList<>(this.books);
        Collections.sort(sortedBooks);
        return Collections.unmodifiableList(sortedBooks);
    }

    public List<Book> listBooksByDesc() {
        List<Book> sortedBooks = new ArrayList<>(this.books);
        Collections.sort(sortedBooks, new Comparator<Book>() {

            @Override
            public int compare(Book o1, Book o2) {
                // TODO Auto-generated method stub
                return o2.getTitle().compareTo(o1.getTitle());
            }

        });
        return Collections.unmodifiableList(sortedBooks);
    }
}
