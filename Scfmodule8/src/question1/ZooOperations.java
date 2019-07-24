package question1;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * This class is used to make various method for 
 * add animal, remove animal, display animal and add zone.
 */
public class ZooOperations {

	Scanner in = new Scanner(System.in);

	ArrayList<Zone> zoneList = new ArrayList<Zone>();

	String name, park, canteen;
	int age;
	float weight;
	int capacity;
	String category;
	int noOfCages;

	/*
	 * This method is used to add zone in zoo.
	 * @return void.
	 */
	public void addZone() {
		System.out.println("enter the category of zone : ");
		category = in.next();
		
		System.out.println("enter the number of cages in zone : ");
		noOfCages = in.nextInt();
		
		System.out.println("want to add park in zone [yes/no]: ");
		park = in.next();
		
		System.out.println("want to add canteen in zone [yes/no]: ");
		canteen = in.next();
		
		zoneList.add(new Zone(category, noOfCages, park, canteen));
		System.out.println("zone added successfully.. ");
	}

	/*
	 * This method is used to display all animal in zone in cage.
	 * @return void.
	 */
	public void display() {

		for (int index1 = 0; index1 < zoneList.size(); index1++) {
			System.out.println("zone number : " + (index1 + 1) + "\t" + " hasPark :" + zoneList.get(index1).hasPark() + "\t" + " hascanteen:"+ zoneList.get(index1).hasCanteen() + "\n");
			
			for (int index2 = 0; index2 < zoneList.get(index1).cages.size(); index2++) {
				System.out.println("cage number : " + (index2 + 1) + "\t" + "cage type : " + zoneList.get(index1).cages.get(index2).type);
				
				for (int index3 = 0; index3 < zoneList.get(index1).cages.get(index2).animals.size(); index3++)
					System.out.println(" id : " + zoneList.get(index1).cages.get(index2).animals.get(index3).aid + "\t" + " name : " + zoneList.get(index1).cages.get(index2).animals.get(index3).name + "\t" + " sound : " + zoneList.get(index1).cages.get(index2).animals.get(index3).getSound());

			}
			System.out.println("\n\n");
		}
	}

	/*
	 * This class is used to add animal of different category
	 * in zone in cage.
	 * @return void.
	 */
	public void addAnimal(String category, String type) {

		for (int index1 = 0; index1 < zoneList.size(); index1++) {
			int index2 = 0;
			if (zoneList.get(index1).category.equals(category)) {

				System.out.println("enter the name ");
				name = in.next();
				System.out.println("enter the age ");
				age = in.nextInt();
				System.out.println("enter the weight ");
				weight = in.nextFloat();

				for (index2 = 0; index2 < zoneList.get(index1).cages.size(); index2++) {
					
					if (zoneList.get(index1).cages.get(index2).type.equals(type) && zoneList.get(index1).cages.get(index2).animals.size() < zoneList.get(index1).cages.get(index2).capacity) {
						
						if (type.equals("lion"))
							zoneList.get(index1).cages.get(index2).animals.add(new Lion(name, age, weight));
						
						if (type.equals("crocodile"))
							zoneList.get(index1).cages.get(index2).animals.add(new Crocodile(name, age, weight));
						
						if (type.equals("peacock"))
							zoneList.get(index1).cages.get(index2).animals.add(new Peacock(name, age, weight));
						
						System.out.println("animal added successfully.. ");
						return;
					}

				}
				if (zoneList.get(index1).cages.size() < zoneList.get(index1).noOfCages) {
					System.out.println("Creating new cage .. \nenter the capacity of cage : ");
					capacity = in.nextInt();
					zoneList.get(index1).cages.add(new Cage(type, capacity));
					
					if (type.equals("lion"))
						zoneList.get(index1).cages.get(index2).animals.add(new Lion(name,age, weight));
					
					if (type.equals("crocodile"))
						zoneList.get(index1).cages.get(index2).animals.add(new Crocodile(name, age, weight));
					
					if (type.equals("peacock"))
						zoneList.get(index1).cages.get(index2).animals.add(new Peacock(name, age, weight));
					
					System.out.println("animal added successfully.. ");
					return;
				}
			}
		}
		System.out.println("No space available in any zone.. pls create a new zone.. ");

	}

	/*
	 * This method is used to remove aniaml from zone and cage.
	 * @retrun void.
	 */
	public void removeAnimal(String name) {

		for (int index1 = 0; index1 < zoneList.size(); index1++) {
			
			for (int index2 = 0; index2 < zoneList.get(index1).cages.size(); index2++) {
				
				for (int index3 = 0; index3 < zoneList.get(index1).cages.get(index2).animals.size(); index3++)
					
					if (zoneList.get(index1).cages.get(index2).animals.get(index3).name.equals(name)) {
						
						zoneList.get(index1).cages.get(index2).animals.remove(index3);
						
						System.out.println("animal removed successfully.. ");
						return;
					}

			}
		}
		System.out.println("animal is not present.. ");

	}
}
