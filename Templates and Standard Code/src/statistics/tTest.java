package statistics;

import java.util.Random;

import org.apache.commons.math3.stat.inference.TTest;

public class tTest {
	
	static Random rand = new Random(System.currentTimeMillis());
	
	public static void main (String [] args) {
		double [] FT = new double [10];
		double [] TS = new double [10];
		TTest ttest = new TTest();
		while (true) {
			randomArray(FT);
			randomArray(TS);
			if (tStat(FT, TS) > 2.101) {
				printArray(FT);
				printArray(TS);
				System.out.println("t stat: " + tStat(FT, TS));
				System.out.println("True");
				System.out.println("java library t stat: " + ttest.pairedT(FT, TS));
				break;
			}
		}
	}
	
	//independent two-sample t-test with equal variance
	//d.f.	probality (two tailed)
	//      0.05	0.01	0.001
	//18	2.101	2.878	3.922
	public static double tStat (double [] A, double [] B) {
		double ts = calcMean(A) - calcMean(B);
		double sdA = standDev(A);
		double sdB = standDev(B);
		double grandsd = Math.sqrt((sdA*sdA)/A.length + (sdB*sdB)/B.length);
		ts /= grandsd;
		return ts;
	}
	
	public static double standDev (double [] A) {
		double sd = 0;
		double mean = calcMean(A);
		for (int i = 0; i < A.length; i++) {
			sd += (A[i] - mean) * (A[i] - mean);
		}
		return Math.sqrt(sd/(double)(A.length-1));
	}
	
	public static double calcMean (double [] A) {
		double mean = 0;
		for (int i = 0; i < A.length; i++) {
			mean += A[i];
		}
		return mean / A.length;
	}
	
	public static void randomArray (double [] A) {
		for (int i = 0; i < A.length; i++) {
			A[i] = rand.nextInt(2); //binary
		}
	}
	
	public static void printArray (double [] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}
