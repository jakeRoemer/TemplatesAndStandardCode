package sortingAlgorithms;

public class QuickSort {
	public static void main (String [] args) {
		int [] quickArray = new int[100];
		createArray.randomizedIntArray(quickArray,100);
		for (int i = 0; i < quickArray.length; i++) {
			System.out.print(quickArray[i] + " ");
		}
		System.out.println();
		quickSort(quickArray);
		for (int i = 0; i < quickArray.length; i++) {
			System.out.print(quickArray[i] + " ");
		}
		System.out.println();
	}
	
	public static void quickSort(int [] totalSyncCount) {
		
	}  
}
