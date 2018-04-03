package generics.crate;

public class ShippableGenericCrate<U> implements Shippable<U>{

	@Override
	public void ship(U t) {
		
	}

	public static <T> Crate<T> create(T u) {
		System.out.println("Creating crate...");
		return new Crate<T>();
	}

	public static <T> void sink(T t) {
		
	}
	
}
