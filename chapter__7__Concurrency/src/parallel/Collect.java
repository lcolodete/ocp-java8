package parallel;

import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Stream;

public class Collect {

	public static void main(String[] args) {
		Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
		
		SortedSet<String> result = stream.collect(ConcurrentSkipListSet::new, 
													(collection, s) -> collection.add(s), 
													(collection1, collection2) -> collection1.addAll(collection2));
		
		System.out.println(result);
	}
}
