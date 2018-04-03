package generics.crate;

public class TestCrate {

	public static void main(String[] args) {
		Crate<Elephant> crateForElephant = new Crate<>();
		Elephant elephant = new Elephant();
		crateForElephant.packCrate(elephant);
		Elephant inNewHome = crateForElephant.emptyCrate();
		
		Zebra z = new Zebra();
		Crate<Zebra> crateForZebra = new Crate<>();
		crateForZebra.packCrate(z);
		
		Robot joeBot = new Robot();
		Crate<Robot> crateForRobot = new Crate<>();
		crateForRobot.packCrate(joeBot);
		
		Robot atDestination = crateForRobot.emptyCrate();
		
		Integer numPounds = 15_000;
		SizeLimitedCrate<Elephant, Integer> c1 = new SizeLimitedCrate<>(elephant, numPounds);
	}
}
