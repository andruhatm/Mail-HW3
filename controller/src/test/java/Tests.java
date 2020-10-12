import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import ru.mail.model.Author;
import ru.mail.model.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tests {
	@Test(expected = IndexOutOfBoundsException.class)
	public void collectionSizeMoreThanCapacity() {
		BooksFactory booksFactory = Mockito.mock(BooksFactory.class);
		List<Book> library = Arrays.asList(
						new Book(new Author("Author0"), "Book 0"),
						new Book(new Author("Author0"), "Book 1"));
		Mockito.when(booksFactory.books()).thenReturn(library);
		new Library(library.size() - 1, booksFactory);
	}

	@Test
	public void correctArrangementOfBooksInTheCell() {
		BooksFactory booksFactory = Mockito.mock(BooksFactory.class);
		List<Book> library = Arrays.asList(
						new Book(new Author("Author0"), "Book 0"),
						new Book(new Author("Author0"), "Book 1"));
		Mockito.when(booksFactory.books()).thenReturn(library);
		Library lib = new Library(library.size(), booksFactory);
		for(int index = 0; index < library.size(); index++) {
			Assert.assertEquals("index: "+index + ", book:" + library.get(index), lib.getBook(index));
		}
	}

	@Test
	public void bookAndCellInfo() {
		BooksFactory booksFactory = Mockito.mock(BooksFactory.class);
		List<Book> library = Arrays.asList(
						new Book(new Author("Author0"), "Book 0"),
						new Book(new Author("Author0"), "Book 1"));
		Mockito.when(booksFactory.books()).thenReturn(library);
		Library lib = new Library(library.size(),booksFactory);
		int index = 0;
		Assert.assertEquals("index: "+index + ", book:" + library.get(index), lib.getBook(index));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void exceptionIfCellIsEmpty() {
		BooksFactory booksFactory = Mockito.mock(BooksFactory.class);
		List<Book> library = new ArrayList<>(1);
		Mockito.when(booksFactory.books()).thenReturn(library);
		Library lib = new Library(library.size(), booksFactory);
		lib.getBook(0);
	}

	@Test
	public void correctBookIsTaken() {
		BooksFactory booksFactory = Mockito.mock(BooksFactory.class);
		List<Book> library = Arrays.asList(
						new Book(new Author("Author0"), "Book 0"),
						new Book(new Author("Author0"), "Book 1"));
		Mockito.when(booksFactory.books()).thenReturn(library);
		Library lib = new Library(library.size(), booksFactory);
		int index = 0;
		Assert.assertEquals("index: "+index + ", book:" + library.get(index), lib.getBook(index));
	}

	@Test
	public void addingABookToTheFirstFreeCell() {
		BooksFactory booksFactory = Mockito.mock(BooksFactory.class);
		List<Book> library = Arrays.asList(
						new Book(new Author("Author0"), "Book 0"),
						null,
						null);
		Mockito.when(booksFactory.books()).thenReturn(library);
		Book book = new Book(new Author("Author0"), "Book 1");
		Library lib = new Library(library.size(), booksFactory);

		lib.addBook(book);
		lib.addBook(book);
		library.set(1,book);
		library.set(2,book);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void exceptionIfLibraryIsFull() {
		BooksFactory booksFactory = Mockito.mock(BooksFactory.class);
		List<Book> library = Arrays.asList(
						new Book(new Author("Author0"), "Book 0"),
						new Book(new Author("Author0"), "Book 1"));
		Mockito.when(booksFactory.books()).thenReturn(library);
		Library lib = new Library(library.size(), booksFactory);
		lib.addBook(new Book(new Author("Author0"), "Book 2"));
	}

	@Test
	public void correctWorkPrintBook() {
		BooksFactory booksFactory = Mockito.mock(BooksFactory.class);

		List<Book> library = Arrays.asList(
						new Book(new Author("Author1"), "Book1"),
						new Book(new Author("Author2"), "Book2"));
		Mockito.when(booksFactory.books()).thenReturn(library);
		Library lib = new Library(library.size(), booksFactory);
		Assert.assertEquals(library.toString(), lib.printBooks());
	}
}
