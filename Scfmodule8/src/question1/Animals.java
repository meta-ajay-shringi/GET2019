package question1;
/*
 * This class used to create animal class.
 * with animal name, id ,age and weight.
 */

public abstract class Animals {
	int aid;
	static int id = 0;
	String name;
	int age;
	float weight;

	abstract String getSound();

}
