import org.jetbrains.annotations.NotNull;
import ru.mail.model.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibraryFactory {

	static Library library;

	public LibraryFactory() throws IOException {
		library = new Library();
	}

	public List<Book> searchByAurthor(@NotNull String authorName){
		List<Book> list = new ArrayList<>();
		for(Book book: getLibrary().lib){
			if (book.getAuthor().getSurname().equals(authorName)){
				list.add(book);
			}
		}
		return list;
	}

	public List<Book> getAllBooks(){
		return new ArrayList<>(Arrays.asList(getLibrary().lib));
	}

	public Library getLibrary() {
		return library;
	}
}
