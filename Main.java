import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] argsArray) {
		List<String> args = Arrays.asList(argsArray);
		Game game = new Game(
			args.contains("-g") || args.contains("--guess")
				? Player.human : Player.computer, 
			args.contains("-c") || args.contains("--code")
				? Player.human : Player.computer
		);
		game.print();
		do {
			game.playTurn();
			if (game.didGuesserWin()) {
				System.out.println("Guesser won!");
				break;
			} else if (game.didCodemakerWin()) {
				System.out.println("Codemaker won!");
				break;
			}
		} while (true);
		TerminalUtils.close();
	}
}
