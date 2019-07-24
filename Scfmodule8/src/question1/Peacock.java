package question1;

/*
 * This class inherit birds class.
 */
public class Peacock extends Birds {
	
	/*
	 * This is constructor of Peacock class.
	 * @param name, This is name of Peacock.
	 * @param age, This is age of Peacock.
	 * @param weight, This is weight of Peacock.
	 */
	Peacock(String name, int age, float weight) {
		this.aid = ++(super.id);
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	public String getSound() {

		return "peaaaauuuu";
	}

}
