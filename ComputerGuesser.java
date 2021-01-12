import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ComputerGuesser extends Guesser {
	ComputerGuesser(Game game) {
		super(game);
	}

	List<List<String>> getPermutations() {
		final Permutations<String> permutations = new Permutations<String>(
			Arrays.asList(ComputerCodemaker.possibleColors),
			ComputerCodemaker.codeLength
		);
		return permutations.getPermutations();
	}

	@Override
	public List<String> getGuess() {
		final List<String> result = new ArrayList<String>();
		for (List<String> permutation : getPermutations()) {
			boolean doesPermutationWork = true;
			for (Attempt attempt : game.attempts) {
				List<String> response = ComputerCodemaker.getResponseForCode(permutation, attempt.code);
				if (!response.equals(attempt.response)) {
					doesPermutationWork = false;
					break;
				}
			}
			if (doesPermutationWork) {
				return permutation;
			}
		}
		throw new NoGuessException();
	}
}
