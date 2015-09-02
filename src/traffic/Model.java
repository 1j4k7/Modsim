package traffic;

public class Model {

	public static void main(String[] args) {
		double sumTime = 0;//in hours
		for (int i = 0; i < 22; i++) {
			double speed = getDensity(i)/14.0;
			sumTime += getDistance(i)/speed;
		}
		System.out.println(sumTime*60);//in minutes
	}
	
	/**
	 * This will get the traffic flow in a certain section of the road
	 * @param section of the road (ordinal)
	 * @return number of cars per hour
	 */
	public static int getDensity(int section) {
		//data all based off of 7:00 AM
		int[] data = {329, 905, 898, 108, 619, 945, 535, 599, 703, 903, 409, 897, 824, 137, 833, 1018, 868, 914, 833, 984, 796, 901};
		return data[section];
	}
	
	/**
	 * This will get the distance traveled along a section of the road
	 * @param section, the intersection that the segment of road begins with
	 * @return distance in miles
	 */
	public static double getDistance(int section) {
		double[] data = {0.5, 0.6, 1, 0.8, 0.4, 0.4, 0.4, 0.2, 1, 0.087, 0.6, 0.2, 0.3, 0.3, 0.2, 0.1, 0.2, 0.3, 0.2, 0.1, 0.2, 0.093};
		return data[section];
	}

}
