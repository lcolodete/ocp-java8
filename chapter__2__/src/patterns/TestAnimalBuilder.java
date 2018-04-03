package patterns;

import java.util.Arrays;

public class TestAnimalBuilder {

	public static void main(String[] args) {
		AnimalBuilder builder = new AnimalBuilder();
		Animal a = builder.setSpecies("lion")
						  .setAge(3)
						  .setFavoriteFoods(Arrays.asList("meat", "more meat"))
						  .build();
		System.out.println( a.getAge() );
		System.out.println(a.getSpecies());
		System.out.println(a.getFavoriteFoods());
		
		Animal flamingo = new AnimalBuilder()
							.setFavoriteFoods(Arrays.asList("algae", "insects"))
							.setSpecies("flamingo")
							.build();
		
		System.out.println(flamingo.getAge());
		System.out.println(flamingo.getSpecies());
		System.out.println(flamingo.getFavoriteFoods());
										
	}
}
