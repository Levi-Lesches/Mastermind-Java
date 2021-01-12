import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class ComputerCodemaker extends Codemaker {
	static boolean canUseColorTwice = false;
	static String[] possibleColors = {"B", "W", "R", "Y", "G", "K"};
	static int codeLength = 4;

	public static List<String> getResponseForCode(List<String> code, List<String> guess) {
		List<String> result = new ArrayList<String>();
		for (int codeIndex = 0; codeIndex < code.size(); codeIndex++) {
			String codeValue = code.get(codeIndex);
			for (int guessIndex = 0; guessIndex < guess.size(); guessIndex++) {
				String guessValue = guess.get(guessIndex);
				if (guessValue.equals(codeValue)) {
					result.add(guessIndex == codeIndex ? "K" : "W");
				}
			}
		}
		result.sort(null);  // don't let users infer code from response order
		return result;
	}

	static List<String> getRandomCode() {
		List<String> result = new ArrayList<String>();
		LinkedList<String> options = new LinkedList<String>(Arrays.asList(possibleColors));
		for (int piece = 0; piece < codeLength; piece++) {
			int index = (int)(Math.random() * options.size());
			result.add(options.get(index));
			if (!canUseColorTwice) {
				options.remove(index);
			}
		}
		return result;
	}

	List<String> code;
	ComputerCodemaker(Game game) {
		super(game);
		this.code = getRandomCode();
	}

	@Override
	public String toString() {
		return String.format("Computer Codemaker (%s)", code);
	}

	public List<String> getResponse(List<String> guess) {
		List<String> result = getResponseForCode(code, guess);
		return result;
	}
}
