import java.util.List;

public abstract class Guesser {
	Game game;

	Guesser(Game game) {
		this.game = game;
	}

	public abstract List<String> getGuess();
}
