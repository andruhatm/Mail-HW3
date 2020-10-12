import com.google.inject.Guice;
import com.google.inject.Injector;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;

public class Application {

	public static void main(@NotNull String[] args) throws IOException {

		final Injector injector = Guice.createInjector(new Module());
		Library library = injector.getInstance(LibraryFactory.class).
						createLib(Integer.parseInt(args[1]));

		library.printAll();

	}
}
