package patterns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Example of immutable class.
 * 
 * Steps to immutability :
 * 
 * 1) Use constructor to set all properties
 * 2) Mark instance variables as private and final
 * 3) Do not include setter methods
 * 4) Guarantee that any mutable object references will not be modified
 * 5) Prevent methods from being overridden.
 * 
 * @author lcolodete@gmail.com
 *
 */
public final class Animal {

	private final String species;
	private final int age;
	private final List<String> favoriteFoods;
	
	public Animal(String species, int age, List<String> favoriteFoods) {
		this.species = species;
		this.age = age;
		if (favoriteFoods == null) {
			throw new RuntimeException("favoriteFoods is required!");
		}
		this.favoriteFoods = new ArrayList<>(favoriteFoods);
	}

	public String getSpecies() {
		return species;
	}

	public int getAge() {
		return age;
	}

	public List<String> getFavoriteFoods() {
		return Collections.unmodifiableList(this.favoriteFoods);
	}
	
}
