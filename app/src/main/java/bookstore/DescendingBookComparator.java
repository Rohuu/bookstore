package bookstore;

import java.util.Comparator;

class DescendingBookComparator implements Comparator<Book> {

    @Override
    public int compare(Book arg0, Book arg1) {
        return arg1.getTitle().compareTo(arg0.getTitle());
    }
}
