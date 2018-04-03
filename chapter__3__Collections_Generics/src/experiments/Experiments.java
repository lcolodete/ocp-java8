package experiments;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Experiments {

	public static void main(String[] args) {
		Experiments e = new Experiments();
		//e.ex1();
//		e.ex2();
//		e.ex3();
//		e.ex4();
//		e.ex5();
//		e.ex6();
//		e.ex7();
//		e.ex8();
//		e.ex9();
		e.ex10();
	}
	
	private void ex1() {
		String[] array = {"orange", "apple"};
		List<String> list = Arrays.asList(array); // returns a fixed size list, NOT an ArrayList!!
		
		printElements("array", array);
		printElements("list", list);
		
		list.set(1, "banana"); // [orange, banana]
		
		printElements("array", array);
		printElements("list", list);
		
		array[0] = "watermelon"; // [watermelon, banana]

		printElements("array", array);
		printElements("list", list);

		String[] array2 = (String[]) list.toArray(); // [watermelon, banana]

		printElements("array", array);
		printElements("list", list);
		printElements("array2", array2);

		list.remove(1); // throws UnsupportedOperationException
	}

	private void printElements(String name, List<?> list) {
		//System.out.println(name+" = "+list);
		StringBuilder sb = new StringBuilder(name);
		sb.append(" = [");
		for (int i = 0; i < list.size(); i++) {
			if (i > 0)
				sb.append(", ");
			Object obj = list.get(i);
			sb.append(obj);
		}
		sb.append("]");
		System.out.println(sb);
	}

	private void printElements(String name, String[] array) {
		StringBuilder sb = new StringBuilder(name);
		sb.append(" = [");
		for (int i = 0; i < array.length; i++) {
			if (i > 0)
				sb.append(", ");
			sb.append(array[i]);
		}
		sb.append("]");
		System.out.println(sb);
	}
	
	private void ex2() {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(new Integer(3));
		numbers.add(new Integer(5));
		
		printElements("numbers", numbers);
		
		numbers.remove(1);
		
		printElements("numbers", numbers);
		
		numbers.remove(new Integer(5));
		
		printElements("numbers", numbers);
		
		
	}
	
	private void ex3() {
		//list accepts ArrayList of Number or anything that "IS-A" Number
//		List<? extends Number> list = new ArrayList<Number>();
		List<? extends Number> list = new ArrayList<Integer>();
		
		//DOES NOT COMPILE
		// when we use upper bounds or unbounded wildcards (?), the list becomes immutable 
		//list.add(new Integer(99));
	}
	
	private void ex4() {
		List<Number> list = new ArrayList<Number>();
		list.add(new Integer(99));
		
		List<? super Number> numbers = list;
		numbers.add(new Integer(444));
		numbers.add(new Float(1f));
		
		List<? super Integer> list2 = new ArrayList<Number>();
		list2.add(new Integer(3));
		//DOES NOT COMPILE
		//list2.add(new Double(1));
	}
	
	private void ex5() {
		List<? super IOException> exceptions = new ArrayList<Exception>();
		exceptions.add(new IOException());
		//DOES NOT COMPILE
		//exceptions.add(new Exception());
		exceptions.add(new FileNotFoundException());
	}
	
	/**
	 * Using ArrayDeque as a Queue implementation.
	 * 
	 * common methods for queue : offer/poll/peek
	 */
	private void ex6() {
		Queue<Integer> queue = new ArrayDeque<>();
		System.out.println( queue.offer(10) );
		System.out.println( queue.offer(4) );
		System.out.println( queue.peek() );
		System.out.println( queue.poll() );
		System.out.println( queue.poll() );
		System.out.println( queue.peek() );
	}
	
	/**
	 * Using ArrayDeque as a stack
	 * 
	 * common methods for stack : push/poll/peek
	 */
	private void ex7() {
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.push(10);
		stack.push(4);
		System.out.println( stack.peek() );
		System.out.println( stack.poll() );
		System.out.println( stack.poll() );
		System.out.println( stack.peek() );
	}
	
	/**
	 * Using LinkedList as a Queue implementation (FIFO)
	 * 
	 * common queue methods : offer/poll/peek
	 */
	private void ex8() {
		Queue<Integer> queue = new LinkedList<>();
		System.out.println( queue.offer(10) );
		System.out.println( queue.offer(4) );
		System.out.println( queue.peek() );
		System.out.println( queue.poll() );
		System.out.println( queue.poll() );
		System.out.println( queue.peek() );
	}
	
	/**
	 * Using a LinkedList as a stack (LIFO)
	 * 
	 * common stack methods : push/pop/peek
	 */
	private void ex9() {
		LinkedList<Integer> stack = new LinkedList<>();
		stack.push(10);
		stack.push(4);
		System.out.println( stack.peek() );
		System.out.println( stack.pop() );
		System.out.println( stack.pop() );
		System.out.println( stack.pop() );
		System.out.println( stack.peek() );
	}
	
	private void ex10() {
//		Queue<Integer> q = new LinkedList<>();
		List<Integer> q = new LinkedList<>();
		q.add(10);
		q.add(12);
		q.remove(1);
		System.out.println(q);
	}
	
//	private void ex1() {
//		
//	}
}
