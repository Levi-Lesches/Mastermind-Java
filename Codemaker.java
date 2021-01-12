import java.util.List;

public abstract class Codemaker {
	Game game;
	Codemaker(Game game) {
		this.game = game;
	}

	public abstract List<String> getResponse(List<String> guess);
}
