import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Game {
	static String correctResponse = "B";

	public List<Attempt> attempts;

	Guesser guesser;
	Codemaker codemaker;

	Game(Player guesserPlayer, Player codemakerPlayer) {
		this.attempts = new ArrayList<Attempt>();
		this.guesser = guesserPlayer == Player.human
			? new PlayerGuesser(this) : new ComputerGuesser(this);
		this.codemaker = codemakerPlayer == Player.human
			? new PlayerCodemaker(this) : new ComputerCodemaker(this);
	}

	boolean didGuesserWin() {
		if (attempts.size() > 10) {
			return false;
		}
		final Attempt attempt = attempts.get(attempts.size() - 1);
		if (attempt.response.size() != 4) {
			return false;
		}
		for (String response : attempt.response) {
			if (!response.equals(correctResponse)) {
				return false;
			}
		}
		return true;
	}

	boolean didCodemakerWin() {
		return attempts.size() == 10;
	}

	void print() {
		TerminalUtils.clearScreen();
		System.out.println(codemaker);
		System.out.println("\nGame so far: ");
		for (int index = 0; index < attempts.size(); index++) {
			Attempt attempt = attempts.get(index);
			System.out.println(String.format("%s: %s", index + 1, attempt));
		}
		System.out.println("");
	}

	void playTurn() {
		List<String> guess = guesser.getGuess();
		List<String> response = codemaker.getResponse(guess);
		Attempt attempt = new Attempt(guess, response);
		attempts.add(attempt);
		print();
	}
}