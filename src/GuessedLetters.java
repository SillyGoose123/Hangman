import java.util.ArrayList;
import java.util.List;

public class GuessedLetters {

	private List<String> guessed = new ArrayList<>();

	public boolean alreadyGuessed(char c) {
		return this.guessed.contains(getCharachter(c));
	}
	
	public void add(char c) {
		this.guessed.add(getCharachter(c));
	}

	private String getCharachter(char c) {
		return ""+Character.toLowerCase(c);
	}
	
	public String getGuessedLetters(String word) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			String wc = getCharachter(word.charAt(i));
			if (guessed.contains(wc)) {
				result.append(wc);
				result.append(" ");
			} else {
				result.append("_ ");
			}
		}
		return result.toString();
	}

	public boolean solved(String word) {
		for (int i = 0; i < word.length(); i++) {
			String wc = getCharachter(word.charAt(i));
			if (guessed.contains(wc) == false) {
				return false;
			}
		}
		return true;
	}
}
