import java.util.List;
import java.util.ArrayList;

class Permutations<E> {
	List<E> objects;
	int n;

	Permutations(List<E> objects) {
		this.objects = objects;
		this.n = objects.size();
	}

	Permutations(List<E> objects, int n) {
		this.objects = objects;
		this.n = n;
	}

	List<List<E>> recurse(List<Integer> indices, List<Integer> availableIndices) {
		List<List<E>> result = new ArrayList<List<E>>();
		if (indices.size() == n) {
			List<E> element = new ArrayList<E>();
			for (int index : indices) {
				element.add(objects.get(index));
			}
			result.add(element);
			return result;
		}
		for (int availableIndex : availableIndices) {
			List<Integer> newIndices = new ArrayList<Integer>(indices);
			List<Integer> newAvailableIndices = new ArrayList<Integer>();
			newIndices.add(availableIndex);
			for (int index : availableIndices) {
				if (index != availableIndex) {
					newAvailableIndices.add(index);
				}
			}
			result.addAll(recurse(newIndices, newAvailableIndices));
		}
		return result;
	}

	public List<List<E>> getPermutations() {
		List<List<E>> result = new ArrayList<List<E>>();
		List<Integer> indices = new ArrayList<Integer>();
		for (int index = 0; index < objects.size(); index++) {
			indices.add(index);
		}
		return recurse(new ArrayList<Integer>(), indices);
	}
}