package generics.crate;

public class ShippableCarCrate extends ShippableGenericCrate<Car> {

	public void test() {
		Car car = new Car();
		this.ship(car);
	}
}
