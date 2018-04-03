package generics.crate;

public class Crate<T> {

	private T contents;
	public T emptyCrate() {
		return this.contents;
	}
	public void packCrate(T contents) {
		this.contents = contents;
	}

	//DOES NOT COMPILE
	// Not allowed because the type is linked to the instance of the class
//	private static T noGood(T u) {
//		
//	}

}
