package parallel;

import java.util.stream.Stream;

public class Reduce {

	public static void main(String[] args) {
		Stream<Character> stream = Stream.of('w','o','l','f');
		
		String result = stream.parallel()
				.reduce("", (s1, c) -> s1 + c, (s2, s3) -> s2 + s3);

		System.out.println(result);
	}
}
