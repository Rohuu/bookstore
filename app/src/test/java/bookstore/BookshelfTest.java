package bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

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

    @Test
    public void should_not_delete_book_from_bookshelf_that_is_not_present() {
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.add(new Book("Effective Java"));
        bookshelf.add(new Book("Clean Code"));
        boolean deleted = bookshelf.delete(new Book("The Pragmatic Programmer"));
        assertThat(deleted).isFalse();
    }

    @Test
    public void should_return_books_in_default_sorting_order() {

        // Arrange
        Bookshelf bookshelf = new Bookshelf();
        Book effectiveJavaBook = new Book("Effective Java");
        bookshelf.add(effectiveJavaBook);
        Book cleanCodeBook = new Book("Clean Code");
        bookshelf.add(cleanCodeBook);
        Book thePragmaticProgrammerBook = new Book("The Pragmatic Programmer");
        bookshelf.add(thePragmaticProgrammerBook);

        // Act
        List<Book> books = bookshelf.listBooks();

        // Assert
        assertThat(books).containsExactly(cleanCodeBook, effectiveJavaBook, thePragmaticProgrammerBook);
    }

    @Test
    public void should_return_books_in_descending_order() {

        // Arrange
        Bookshelf bookshelf = new Bookshelf();
        Book effectiveJavaBook = new Book("Effective Java");
        bookshelf.add(effectiveJavaBook);
        Book cleanCodeBook = new Book("Clean Code");
        bookshelf.add(cleanCodeBook);
        Book thePragmaticProgrammerBook = new Book("The Pragmatic Programmer");
        bookshelf.add(thePragmaticProgrammerBook);

        // Act
        List<Book> books = bookshelf.listBooksByDesc();

        // Assert
        assertThat(books).containsExactly(thePragmaticProgrammerBook, effectiveJavaBook, cleanCodeBook);
    }

    // new requirement-> should be able to share if bookshelf is public

    @Test
    public void should_throw_exception_if_we_try_to_share_a_private_bookshelf() {
        Bookshelf bookshelf = new Bookshelf(false);
        try {
            bookshelf.share(null, null);
            fail("This should not happen");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalStateException.class);
        }
    }

    @Test
    public void should_share_public_bookshelf() {
        Bookshelf bookshelf = new Bookshelf(true);
        boolean shared = bookshelf.share("email", "test@example.com");
        assertThat(shared).isTrue();
    }
}
