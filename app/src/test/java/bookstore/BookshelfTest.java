package bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

public class BookshelfTest {
    @Test
    public void should_add_book_to_bookshelf() {
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.add(new Book("Effective Java"));
        int count = bookshelf.noOfBooks();
        assertThat(count).isEqualTo(1);
    }

    @Test
    public void should_not_allow_same_book_to_be_added_to_bookshelf() {
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.add(new Book("Effective Java"));
        try {
            bookshelf.add(new Book("Effective Java"));
            fail("This should not happen");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
            assertThat(e.getMessage()).isEqualTo("You can't add same book twice");
        }
    }

    @Test
    public void should_delete_an_existing_book_from_bookshelf() {
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.add(new Book("Effective Java"));
        bookshelf.add(new Book("Clean Code"));
        boolean deleted = bookshelf.delete(new Book("Effective Java"));
        assertThat(deleted).isTrue();
    }

    // new requirement-> should be able to share if bookshelf is public

    // @Test
    // public void should_throw_exception_if_we_try_to_share_a_private_bookshelf() {
    // Bookshelf bookshelf = new Bookshelf();
    // try {
    // bookshelf.share();
    // assertThat(e).isInstanceOf(IllegalStateException.class);
    // fail("This should not happen");
    // } catch (Exception e) {
    // }

    // }
}
