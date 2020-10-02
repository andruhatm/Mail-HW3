import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;
import ru.mail.model.Book;
import java.io.IOException;
import java.util.Scanner;

public class Application {

	public static void main(@NotNull String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);
		Gson gson = new Gson();
		LibraryFactory libraryFactory = new LibraryFactory();

		System.out.println("Enter author's surname, please");
		String enter = scanner.nextLine();
		System.out.println("\r");

		//outputs books for choosen author
		if(libraryFactory.searchByAurthor(enter).isEmpty()){
			System.out.println("No books for such author");
		}
		else {
			for(Book book: libraryFactory.searchByAurthor(enter)){
				System.out.println(gson.toJson(book));
			}
		}

		System.out.println("\nAll books\n");
		//outputs all Library books
		for(Book book: libraryFactory.getAllBooks()){
			System.out.println(gson.toJson(book));
		}

	}
}
