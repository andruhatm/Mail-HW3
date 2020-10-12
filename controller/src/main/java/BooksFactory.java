import ru.mail.model.Book;

import java.util.Collection;

public interface BooksFactory {
	public Collection<Book> books();
}
