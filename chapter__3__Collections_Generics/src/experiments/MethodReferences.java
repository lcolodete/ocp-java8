package experiments;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MethodReferences {

	public static void main(String[] args) {
		MethodReferences m = new MethodReferences();
		m.ex1();
	}
	
	private void ex1() {
		String str = "Leo";
		
//		Predicate<String> filter = s -> str.startsWith(s);
		Predicate<String> filter = str::startsWith;
		
//		Predicate<String> filter = s -> s.startsWith(str);
		
		
		List<String> list = Arrays.asList("Leandro", "Leonardo", "Leovegildo", "Lian", "Leo", "Le");
		
		list.stream().filter(filter).forEach(System.out::println);
	}
}
