import com.google.inject.AbstractModule;

public class Module extends AbstractModule {
	@Override
	protected void configure() {
		bind(BooksFactory.class).toInstance(new FileBookFactory("controller/src/main/resources/books.txt"));
	}
}
