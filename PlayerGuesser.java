import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PlayerGuesser extends Guesser {
	PlayerGuesser(Game game) {
		super(game);
	}

	@Override
	public List<String> getGuess() {
		return TerminalUtils.getColor();
	}
}
