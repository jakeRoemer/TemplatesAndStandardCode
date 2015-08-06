package sortingAlgorithms;

import java.util.Random;

public class createArray {

	public static void randomizedIntArray (int [] A, int dataSizeLimit) {
		Random rand = new Random(System.currentTimeMillis());
		for (int i = 0; i < A.length; i++) {
			A[i] = rand.nextInt(dataSizeLimit);
		}
	}
	
	public static void randomizedDoubleArray (double [] A, int dataSizeLimit) {
		Random rand = new Random(System.currentTimeMillis());
		for (int i = 0; i < A.length; i++) {
			A[i] = rand.nextDouble()*dataSizeLimit;
		}
	}
} 
