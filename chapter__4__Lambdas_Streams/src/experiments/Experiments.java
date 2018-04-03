package experiments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.DoubleFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Experiments {

	private void ex1() {
		Map<String, Integer> map = new HashMap<>();
		BiConsumer<String, Integer> c1 = map::put;
		BiConsumer<String, Integer> c2 = (k, v) -> map.put(k, v);
		
		BiConsumer<String, Integer> c3 = (k, v) -> {
			map.put(k, v);
		};
		
		c1.accept("chicken", 7);
		c2.accept("chick", 1);
		c2.accept("rooster", 10);
		
		System.out.println(map);

	}
	
	private void ex2() {
		BiPredicate<String, String> p1 = String::startsWith;
		BiPredicate<String, String> p2 = (s, prefix) -> s.startsWith(prefix);
		
		System.out.println(p1.test("chicken", "chick"));
		System.out.println(p2.test("chicken", "chick"));
		System.out.println(p1.test("rooster", "chick"));
	}
	
	private void ex3() {
		Predicate<String> egg = s -> s.contains("egg");
		Predicate<String> brown = s -> s.contains("brown");
		
//		System.out.println(egg.test("egg"));
//		System.out.println(egg.test("car"));
//		System.out.println(brown.test("brown"));
//		System.out.println(brown.test("red"));
		
		Predicate<String> brownEggs = egg.and(brown);
		Predicate<String> otherEggs = egg.and(brown.negate());
		
		System.out.println(brownEggs.test("brown eggs"));
		System.out.println(brownEggs.test("white eggs"));
		
		System.out.println(otherEggs.test("brown eggs"));
		System.out.println(otherEggs.test("white eggs"));
		
	}
	
	private void ex4() {
		System.out.println(average(90, 100));
		System.out.println(average());
		
		Optional<Double> opt = average(90, 100);
//		if (opt.isPresent()) 
//			System.out.println(opt.get());
		opt.ifPresent(System.out::println);

		System.out.println(createOptional(null));
		System.out.println(createOptional("test"));

		Optional<Double> opt2 = average();
//		System.out.println(opt2.get()); // throws NoSuchElementException!
		opt2.ifPresent(System.out::println);
		System.out.println(opt2.orElse(Double.NaN));
		System.out.println(opt2.orElseGet(() -> Math.random()));
		System.out.println(opt2.orElseThrow(IllegalStateException::new));
	}
	
	public static Optional<String> createOptional(String value) {
		return Optional.ofNullable(value);
	}
	
	public static Optional<Double> average(int... scores) {
		if (scores.length == 0) {
			return Optional.empty();
		}
		int sum = 0;
		for (int score : scores) {
			sum += score;
		}
		return Optional.of((double) sum / scores.length);
	}
	
	private void ex5() {
		Stream<String> empty = Stream.empty();
		Stream<Integer> fromArray = Stream.of(1, 2, 3);
		
//		fromArray.forEach(System.out::println);
		
		Stream<Double> randoms = Stream.generate(Math::random);
		randoms.limit(3).forEach(System.out::println);
		
		Stream<Integer> oddNumbers = Stream.iterate(1, n -> n +2);
		oddNumbers.limit(10).forEach(System.out::println);
	}
	
	private void ex6() {
		Stream<String> s = Stream.of("monkey", "ape", "bonobo");
		Optional<String> min = s.min((s1, s2) -> s1.length() - s2.length());
//		Optional<String> min = s.min((s1, s2) -> s2.compareToIgnoreCase(s1));
		
		System.out.println(min.isPresent());
		min.ifPresent(System.out::println);
		
		Optional<?> min2 = Stream.empty().min((s1, s2) -> 0);
		System.out.println(min2.isPresent());
	}
	
	private void ex7() {
		Stream<String> s = Stream.of("bonobo", "ape", "monkey");
		s.findAny().ifPresent(System.out::println);
//		s.findFirst().ifPresent(System.out::println);
		
		Stream<String> infinite = Stream.generate( () -> "chimp" );
//		infinite.limit(5).forEach(System.out::println);
		infinite.findAny().ifPresent(System.out::println);
	}
	
	private void ex8() {
		List<String> list = Arrays.asList("monkey", "2", "chimp");
		Stream<String> infinite = Stream.generate( () -> "chimp" );
		Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
		
		System.out.println(list.stream().anyMatch(pred));
		System.out.println(list.stream().allMatch(pred));
		System.out.println(list.stream().noneMatch(pred));
		
		System.out.println(infinite.anyMatch(pred));
//		System.out.println(infinite.noneMatch(pred));
//		System.out.println(infinite.allMatch(pred));
		
		list.forEach(System.out::print);
	}
	
	private void ex9() {
		Stream<Integer> s = Stream.of(1, 2, 3, 4, 5);
		
//		long count = s.peek(System.out::println).count();
//		System.out.println("count="+count);
		
		Integer i = s.reduce(1, (x, y) -> x * y);
		System.out.println(i);
		
		Stream<String> s1 = Stream.of("w", "o", "l", "f");
//		String word = s1.reduce("", (letter1, letter2) -> letter1+letter2);
		String word = s1.reduce("", String::concat);
		System.out.println(word);
	}
	
	private void ex10() {
		Stream<Integer> empty = Stream.empty();
//		Integer i = empty.reduce(1, (x, y) -> x * y);
//		System.out.println(i);
		System.out.println( empty.reduce((x, y) -> x * y).isPresent() );
		
	}
	
	private void ex11() {
		Stream<String> s = Stream.of("w", "o", "l", "f");
//		StringBuilder word = s.collect(StringBuilder::new, (x, y) -> x.append(y), (x, y) -> x.append(y));
		StringBuilder word = s.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		System.out.println(word);
		
		s = Stream.of("w", "o", "l", "f");
//		TreeSet<String> set = s.collect(TreeSet::new, (x, y) -> x.add(y), (x, y) -> x.addAll(y));
		TreeSet<String> set = s.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
		System.out.println(set);
	}
	
	private void ex12() {
		Stream<String> s = Stream.of("w", "o", "l", "f");
		TreeSet<String> set = s.collect(Collectors.toCollection(TreeSet::new));
//		Set<String> set = s.collect(Collectors.toSet());
		System.out.println(set);
	}
	
	/**
	 * Get the first two names alphabetically that are 4 characters long.
	 * 
	 * Spliting up the requirements:
	 * 
	 * 1) first two
	 * 2) alphabetically
	 * 3) 4 characters long
	 */
	private void ex13() {
		//before Java 8 : imperative way
		
		System.out.println("before Java 8 : imperative way");
		
		List<String> names = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
		List<String> result = new ArrayList<>();
		
		for (String s : names) {
			if (s.length() == 4) 
				result.add(s);
		}
		
		Collections.sort(result);
		
		Iterator<String> i = result.iterator();
		if (i.hasNext())
			System.out.println(i.next());
		if (i.hasNext()) 
			System.out.println(i.next());
		
		
		//Java 8 : using lambdas and streams
		
		System.out.println("Java 8 : using lambdas and streams");
		
		Stream<String> s = names.stream();
		List<String> resultList = s.filter(x -> x.length() == 4)
		 .sorted()
		 .limit(2)
//		 .forEach(System.out::println);
		 .collect(Collectors.toList());
		
		System.out.println(resultList);
	}
	
	private void ex14() {
		double d = 1.0;
		ToIntFunction<Double> f1 = x -> 1;
		System.out.println( f1.applyAsInt(d) );
		
		DoubleToIntFunction f2 = x -> 1;
		System.out.println( f2.applyAsInt(d) );
		
		DoubleFunction<Integer> f3 = x -> 1;
		System.out.println( f3.apply(d) );
	}
	
	private void ex15() {
		Stream<String> animals = Stream.of("lions", "tigers", "bears");
//		String s = animals.collect(Collectors.joining(",")); // lions,tigers,bears
//		String s = animals.collect(Collectors.joining(" - ", "BEGIN : [", "] -- END")); // BEGIN : [lions - tigers - bears] -- END
		
//		OptionalDouble optional = animals.mapToInt(String::length).average();
//		System.out.println(optional.getAsDouble());
		
		Double average = animals.collect(Collectors.averagingInt(String::length));
		System.out.println(average);
		
//		System.out.println(s);
	}
	
	private void ex16() {
		Stream<String> animals = Stream.of("lions", "tigers", "bears");
//		Map<Integer, List<String>> map = animals.collect(Collectors.groupingBy(String::length));
//		Map<Integer, Long> map = animals.collect(Collectors.groupingBy(String::length, Collectors.counting()));
		
		Map<Integer, Optional<Character>> map = animals.collect(
								Collectors.groupingBy(String::length, 
										Collectors.mapping(s -> s.charAt(0), Collectors.minBy(Comparator.naturalOrder()))
										
								)
						);
		
		System.out.println(map);
	}
	
	private void ex17() {
//		IntStream.range(1, 6).forEach(System.out::println);
		List<Integer> list = IntStream.range(1, 6).mapToObj(i -> i).collect(Collectors.toList());
		list.forEach((i) -> System.out.println("> "+i));
	}
	
	private void ex18() {
		System.out.println( Stream.iterate(1, x -> ++x).limit(5).map(x -> String.valueOf(x)).collect(Collectors.joining()) );
	}
	
	public static void main(String[] args) {
		Experiments e = new Experiments();
//		e.ex1();
//		e.ex2();
//		e.ex3();
//		e.ex4();
//		e.ex5();
//		e.ex6();
//		e.ex7();
//		e.ex8();
//		e.ex9();
//		e.ex10();
//		e.ex11();
//		e.ex12();
//		e.ex13();
//		e.ex14();
//		e.ex15();
//		e.ex16();
//		e.ex17();
		e.ex18();
	}
	

}
