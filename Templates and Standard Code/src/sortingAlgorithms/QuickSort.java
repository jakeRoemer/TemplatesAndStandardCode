package sortingAlgorithms;

public class QuickSort {
	public static void main (String [] args) {
		int [] quickArray = new int[10000];
		createArray.randomizedIntArray(quickArray,100);
		for (int i = 0; i < quickArray.length; i++) {
			System.out.print(quickArray[i] + " ");
		}
		System.out.println();
		long start = System.currentTimeMillis();
		quickSort(quickArray, 0, quickArray.length-1);
		long time = System.currentTimeMillis() - start;
		System.out.println("time: " + time);
		for (int i = 0; i < quickArray.length; i++) {
			System.out.print(quickArray[i] + " ");
		}
		System.out.println();
	}
	
	public static void quickSort (int [] quickArray, int start, int end) {
		if (start < end) {
			int mid = partition(quickArray, start, end);
			quickSort(quickArray, start, mid-1);
			quickSort(quickArray, mid+1, end);
		}
	}
	
	public static int partition (int [] quickArray, int start, int end) {
		int q = quickArray[end];
		int index = start-1;
		for (int i = start; i < end; i++) {
			if (quickArray[i] <= q) {
				index++;
				swap(quickArray,index,i);
			}
		}
		index++;
		swap(quickArray,index,end);
		return index;
	}
	
	public static void swap (int [] quickArray, int i, int j) {
		int temp = quickArray[i];
		quickArray[i] = quickArray[j];
		quickArray[j] = temp;
	}
}
