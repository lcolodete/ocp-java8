package patterns;

import java.util.Arrays;

public class TestAnimal {

	public static void main(String[] args) {
		Animal a = new Animal("lion", 5, Arrays.asList("meat", "more meat"));
		System.out.println(a.getAge());
		System.out.println(a.getSpecies());
		System.out.println(a.getFavoriteFoods());
		
		for (String food : a.getFavoriteFoods()) 
			System.out.println(food);
		
		a.getFavoriteFoods().add("new food");
	}
}

