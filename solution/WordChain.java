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
		List<String> tempchain = new ArrayList<String>();
		tempchain.add(from);
		foundNextWord(tempchain, to);

		return this.wordchain.toArray(new String[0]);
	}

	private void foundNextWord(List<String> tempchain, String goal) {
		String current = tempchain.get(tempchain.size() - 1);
		int size = tempchain.size();
		boolean found = false;
		for (int modifier = 0; !found && (modifier <= 1); modifier++) {
			for (String word : dictionary) {
				if (word.length() == current.length()
					&& !tempchain.contains(word)
					&& isClose(current, word, current.length() - 1, true)
					&& isClose(word, goal, size - modifier, false)
				) {
					found = true;
					List<String> clonechain = new ArrayList<>(tempchain);
					clonechain.add(word);				
					if (word.equals(goal) 
						&& (this.wordchain.size() == 0 || clonechain.size() < this.wordchain.size())
					) {
						this.wordchain = clonechain;
					} else {
						foundNextWord(clonechain, goal);
					}
				}
			}
		}
	}

	private boolean isClose(String a, String b, int compare, boolean exact) {
		int equals = 0;
		for (int i = 0; i < b.length(); i++) {
			if (a.charAt(i) == b.charAt(i)) {
				equals++;
			}
		}
		return exact ? compare == equals : equals >= compare;
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