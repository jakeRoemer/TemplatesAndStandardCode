package sortingAlgorithms;

public class InsertionSort {
	public static void main(String [] args) {
		int [] totalSyncCount = new int[5];
		createArray.randomizedIntArray(totalSyncCount,100);
		for (int i = 0; i < totalSyncCount.length; i++) {
			System.out.print(totalSyncCount[i] + " ");
		}
		System.out.println();
		insertSort(totalSyncCount);
		for (int i = 0; i < totalSyncCount.length; i++) {
			System.out.print(totalSyncCount[i] + " ");
		}
		System.out.println();
	}
	
	public static void insertSort(int [] totalSyncCount) {
		for (int i = 1; i < totalSyncCount.length; i++) {
			int val = totalSyncCount[i];
			int j = 0;
			while (j < i && val >= totalSyncCount[j]) {
				j++;
			}
			for (int k = i-1; k >= j; k--) {
				totalSyncCount[k+1] = totalSyncCount[k];
			}
			totalSyncCount[j] = val;
		}
	}
}
