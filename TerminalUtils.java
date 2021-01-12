import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TerminalUtils {
	static public Scanner scanner = new Scanner(System.in);

	static public void clearScreen() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException | IOException error) {

		}
	}

	static public List<String> getColor() {
		String input = scanner.nextLine();
		List<String> result = Arrays.asList(input.split(" "));
		if (result.size() != 4) {
			throw new IndexOutOfBoundsException("Invalid response: " + input);
		}
		return result;
	}

	static public void close() {
		scanner.close();
	}
}