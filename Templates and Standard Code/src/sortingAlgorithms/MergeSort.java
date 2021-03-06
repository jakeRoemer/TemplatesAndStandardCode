package sortingAlgorithms;

public class MergeSort {
	public static void main(String [] args) {
		int [] mergeArray = new int[10000];
		createArray.randomizedIntArray(mergeArray,100);
		for (int i = 0; i < mergeArray.length; i++) {
			System.out.print(mergeArray[i] + " ");
		}
		System.out.println();
		long start = System.currentTimeMillis();
		mergeSort(mergeArray, 0, mergeArray.length-1);
		long time = System.currentTimeMillis() - start;
		System.out.println("time: " + time);
		for (int i = 0; i < mergeArray.length; i++) {
			System.out.print(mergeArray[i] + " ");
		}
		System.out.println();
	}
	
	public static void mergeSort (int [] totalSyncCount, int start, int end) {
		if (start < end) {
			int mid = (start+end)/2;
			mergeSort(totalSyncCount, start, mid);
			mergeSort(totalSyncCount, mid+1, end);
			merge(totalSyncCount, start, mid, end);
		}
	}
	
	public static void merge (int [] totalSyncCount, int start, int mid, int end) {
		int n = mid - start + 1;
		int m = end - mid;
		int [] left = new int[n+1];
		int [] right = new int[m+1];
		int i;
		for (i = 0; i < n; i++) {
			left[i] = totalSyncCount[start+i];
		}
		int j;
		for (j = 0; j < m; j++) {
			right[j] = totalSyncCount[mid+j+1];
		}
		left[n] = Integer.MAX_VALUE;
		right[m] = Integer.MAX_VALUE;
		i = 0;
		j = 0;
		for (int k = start; k <= end; k++) {
			if (left[i] <= right[j])  {
				totalSyncCount[k] = left[i];
				i++;
			} else {
				totalSyncCount[k] = right[j];
				j++;
			}
		}
	}
}
