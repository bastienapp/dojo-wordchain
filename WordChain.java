import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class WordChain {

	public static String[] solves(String from, String to) {
		List<String> dictionary = getDictionary();
		List<String> wordchain = new ArrayList<String>();

		// TODO

		return wordchain.toArray(new String[0]);
	}

	public static List<String> getDictionary() {
		List<String> dictionary = new ArrayList<String>();

		try {
			File file = new File("dictionary.txt");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {				
				dictionary.add(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.print("dictionary.txt not found");
		}

		return dictionary;
	}
}