package sortingAlgorithms;

import java.util.Random;

public class InsertionSort {
	public static void main(String [] args) {
		int [] totalSyncCount = new int[5];
		insertSort(totalSyncCount);
		for (int i = 0; i < totalSyncCount.length; i++) {
			System.out.println(totalSyncCount[i]);
		}
	}
	
	//creates new numbers to insert into array while keeping the array sorted [smallest to largest]
	public static void insertSort(int [] totalSyncCount) {
		int val;
		Random rand = new Random(System.currentTimeMillis());
	    for (int k = 0; k < totalSyncCount.length; k++) {
	      //can not switch on zero acquire
	      val = rand.nextInt(100)+1;
	      for (int i = totalSyncCount.length-1; i >= 0; i--) {
				if (val >= totalSyncCount[i]) {
					for (int j = 1; j <= i; j++) {
						int temp = totalSyncCount[j];
						totalSyncCount[j] =  totalSyncCount[j-1];
						totalSyncCount[j-1] = temp;
					}
					totalSyncCount[i] = val;
					break;
				}
			}
	    }
	}
	
	public static void insert(int [] totalSyncCount, int val) {
		for (int i = totalSyncCount.length-1; i >= 0; i--) {
			if (val >= totalSyncCount[i]) {
				for (int j = 1; j <= i; j++) {
					int temp = totalSyncCount[j];
					totalSyncCount[j] =  totalSyncCount[j-1];
					totalSyncCount[j-1] = temp;
				}
				totalSyncCount[i] = val;
				break;
			}
		}
	}
}
