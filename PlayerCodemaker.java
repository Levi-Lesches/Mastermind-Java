import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class PlayerCodemaker extends Codemaker {
	PlayerCodemaker(Game game) {
		super(game);
	}

	@Override
	public List<String> getResponse(List<String> guess) {
		System.out.print("The guesser guessed: ");
		System.out.println(guess);
		return TerminalUtils.getColor();
	}
} 