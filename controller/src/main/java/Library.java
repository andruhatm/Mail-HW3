import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;
import ru.mail.model.Book;

import java.io.*;

public class Library {
	Book[] lib;

	public Library() throws IOException {
		this.lib = readData("books.txt");
	}

	public Book[] readData(@NotNull String path) throws IOException {

		FileReader file = new FileReader(path);

		//JsonReader reader = new JsonReader(new InputStreamReader(in, StandardCharsets.UTF_8));
		StringBuilder info = new StringBuilder();
		int r;
		while((r=file.read())!=-1){
			info.append((char) r);
		}

		Gson gson = new Gson();
		//Type listType = new TypeToken<ArrayList<Book>>(){}.getType();

		return gson.fromJson(String.valueOf(info), Book[].class);
	}

}
