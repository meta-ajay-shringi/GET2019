package question1;

import java.util.ArrayList;
/*
 * This class is used to create cage with atribuite 
 * type and capacity and animal.
 */
public class Cage {

	String type;
	int capacity;
	ArrayList<Animals> animals;

	/*
	 * This is constructor of cage.
	 * @param type, This is type of animal.
	 * @param capacity, This is capacity of cage.
	 */
	Cage(String type, int capacity) {

		animals = new ArrayList<Animals>(capacity);
		this.type = type;
		this.capacity = capacity;
	}

}
