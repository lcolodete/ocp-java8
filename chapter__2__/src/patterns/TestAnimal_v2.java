package patterns;

import java.util.Arrays;

public class TestAnimal_v2 {

	public static void main(String[] args) {
		Animal_v2 duck = Animal_v2.getBuilder()
						.setAge(10)
						.setFavoriteFoods(Arrays.asList("grass", "fish"))
						.setSpecies("duck")
						.build();
		
		System.out.println(duck.getAge());
		System.out.println(duck.getSpecies());
		System.out.println(duck.getFavoriteFoods());
	}
}
