package question1;

/*
 * This class inherit reptiles class.
 */
public class Crocodile extends Reptiles {

	/*
	 * This is constructor of crocodile class.
	 * @param name, This is name of crocodile.
	 * @param age, This is age of crocodile.
	 * @param weight, This is weight of crocodile.
	 */
	Crocodile(String name, int age, float weight) {
		this.aid = ++(super.id);
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	public String getSound() {

		return "ghrrr";
	}
}
