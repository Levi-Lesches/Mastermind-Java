import java.util.List;
import java.util.ArrayList;

public class Attempt {
	final List<String> code;
	final List<String> response;

	Attempt(List<String> code, List<String> response) {
		this.code = code;
		this.response = response;
	}

	@Override
	public String toString() {
		return String.format("%s  |  %s", code.toString(), response.toString());
	}
}
