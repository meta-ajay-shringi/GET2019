package question1;

import java.util.ArrayList;
/*
 * This class is zone of animals.where one zone have same category of animals
 * but multiple zone for same category.
 */
public class Zone {

	String category;
	int noOfCages;
	boolean park;
	boolean canteen;
	ArrayList<Cage> cages;

	/*
	 *  This is constructor of zone class.
	 *  @param category, This is category of zone.
	 *  @param noOfCage, This is no of cage in zone.
	 *  @param park, This is park in zone.
	 *  @param canteen, This is canteen in zone.
	 */
	Zone(String category, int noOfCages, String park, String canteen) {

		cages = new ArrayList<Cage>();

		this.category = category;
		this.noOfCages = noOfCages;
		
		if (park.equals("yes"))
			this.park = true;
		else
			this.park = false;

		if (canteen.equals("yes"))
			this.canteen = true;
		else
			this.canteen = false;

	}

	boolean hasPark() {
		return park;
	}

	boolean hasCanteen() {
		return canteen;
	}

}
