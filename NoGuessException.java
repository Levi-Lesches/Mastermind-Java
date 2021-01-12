import java.lang.RuntimeException;

public class NoGuessException extends RuntimeException {
	NoGuessException() {
		super("No guesses are valid. Please make sure you responded correctly to my previous guesses");
	}
}