package functional;

import java.util.function.Predicate;

public class FindMatchingAnimals {

//	private static void print(Animal a, CheckTrait check) {
	private static void print(Animal a, Predicate<Animal> check) {
		if (check.test(a))
			System.out.println("> Animal passed the test : "+a);
	}
	
	public static void main(String[] args) {
		System.out.println("Animals that can hop:");
		print(new Animal("fish", false, true), a -> a.canHop());
		print(new Animal("kangaroo", true, false), a -> a.canHop());
		print(new Animal("Rabbit", true, false), a -> a.canHop());
		
		System.out.println("Animals that can swim:");
		print(new Animal("fish", false, true), a -> a.canSwim());
		print(new Animal("kangaroo", true, false), a -> a.canSwim());
		print(new Animal("Rabbit", true, false), a -> a.canSwim());
	}
}

class Animal {
	private boolean canSwim;
	private boolean canHop;
	private String species;
	public Animal(String species, boolean canHop, boolean canSwim) {
		super();
		this.canSwim = canSwim;
		this.canHop = canHop;
		this.species = species;
	}
	
	public String toString() {
		return species;
	}
	public boolean canHop() {
		return canHop;
	}
	public boolean canSwim() {
		return canSwim;
	}
}
