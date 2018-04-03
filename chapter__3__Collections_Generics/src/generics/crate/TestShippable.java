package generics.crate;

public class TestShippable {

	public static void main(String[] args) {
		Zebra z = new Zebra();
		ShippableGenericCrate<Zebra> shippableCrate = new ShippableGenericCrate<>();
		shippableCrate.ship(z);
		Crate<Zebra> zebraCrate = ShippableGenericCrate.create(z);
		zebraCrate.packCrate(z);
		
		Elephant e = new Elephant();
		ShippableGenericCrate.sink(e);
		
		ShippableGenericCrate.<Elephant>sink(e);
	}
}
