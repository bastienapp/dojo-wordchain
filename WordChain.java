import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class WordChain {

	private List<String> dictionary;
	private List<String> wordchain;

	public WordChain() {
		this.dictionary = getDictionary();
		this.wordchain = new ArrayList<String>();
	}

	public String[] solves(String from, String to) {
		
		// TODO

		return this.wordchain.toArray(new String[0]);
	}

	private List<String> getDictionary() {
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