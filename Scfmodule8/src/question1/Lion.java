package question1;

/*
 * This class inherit mammals class.
 */
public class Lion extends Mammals {
	
	/*
	 * This is constructor of lion class.
	 * @param name, This is name of lion.
	 * @param age, This is age of lion.
	 * @param weight, This is weight of lion.
	 */
	Lion(String name, int age, float weight) {
		this.aid = ++(super.id);
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	public String getSound() {
		return "roar";
	}

}
