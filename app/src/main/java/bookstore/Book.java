package bookstore;

public class Book implements Comparable<Book> { /* implements Comparable<Book> */
    private String title;

    public Book(String title) {
        this.title = title;
    }

    // public void title(String title) {
    // this.title = title;
    // }

    public String getTitle() {
        return title;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

    @Override
    public int compareTo(Book o) {
        // TODO Auto-generated method stub
        return this.title.compareTo(o.title);
    }

    @Override
    public String toString() {
        return "Book [title=" + title + "]";
    }

}
