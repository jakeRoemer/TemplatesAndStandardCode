package statistics;

public class chiSquaredTest {
	
	//TODO: make abstract for any kind of values as input
	//TODO: possibly pass method as argument and call method to get values instead of passing values
	//values are observed values, occurrences are how many observed values taken, range is the range in which the values can exist [ie. 0 to 10]
	//sum must be taken of all observed - expected squared divided by expected
	//table is then 
	public static boolean testing (int [] values, int occurrences, int range) {
		double sum = 0;
		double expected = occurrences / range;
		for (int i = 0; i < values.length; i++) {
			sum += ((values[i] - expected) * (values[i] - expected)) / expected;
		}
		System.out.println(sum);
		return sum <= 16.919; //9 degrees of freedom with 0.05 confidence
	}
}
