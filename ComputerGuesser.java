import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

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

	<E> boolean responsesAreEqual(List<E> a, List<E> b) {
		HashMap<E, Integer> countA = new HashMap<E, Integer>();
		HashMap<E, Integer> countB = new HashMap<E, Integer>();
		for (E element : a) {
			if (countA.containsKey(element)) {
				int count = countA.get(element);
				countA.put(element, count + 1);
			} else {
				countA.put(element, 1);
			}
		}
		for (E element : b) {
			if (countB.containsKey(element)) {
				int count = countB.get(element);
				countB.put(element, count + 1);
			} else {
				countB.put(element, 1);
			}
		}
		for (E element : a) {
			if (countA.get(element) != countB.get(element)) {
				return false;
			}
		}
		for (E element : b) {
			if (countA.get(element) != countB.get(element)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public List<String> getGuess() {
		final List<String> result = new ArrayList<String>();
		for (List<String> permutation : getPermutations()) {
			boolean doesPermutationWork = true;
			for (Attempt attempt : game.attempts) {
				List<String> response = ComputerCodemaker.getResponseForCode(permutation, attempt.code);
				if (!responsesAreEqual(response, attempt.response)) {
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
