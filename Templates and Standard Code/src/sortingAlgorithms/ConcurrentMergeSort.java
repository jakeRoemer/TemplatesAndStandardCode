package sortingAlgorithms;

public class ConcurrentMergeSort {
	public static void main(String [] args) {
		int [] concurrentMergeArray = new int[10000];
		createArray.randomizedIntArray(concurrentMergeArray,100);
		for (int i = 0; i < concurrentMergeArray.length; i++) {
			System.out.print(concurrentMergeArray[i] + " ");
		}
		System.out.println();
		long start = System.currentTimeMillis();
		Thread t = new Thread(new MergeThread(concurrentMergeArray, 0, concurrentMergeArray.length-1));
		t.start();
		try { 
			t.join();
			long time = System.currentTimeMillis() - start;
			System.out.println("time: " + time);
		} catch (InterruptedException e) { }
		for (int i = 0; i < concurrentMergeArray.length; i++) {
			System.out.print(concurrentMergeArray[i] + " ");
		}
		System.out.println();
	}
	
	static class MergeThread implements Runnable {
		int [] totalSyncCount;
		int start;
		int end;
		public MergeThread(int [] totalSyncCount, int start, int end) {
			this.totalSyncCount = totalSyncCount;
			this.start = start;
			this.end = end;
		}
		public void run() {
			mergeSort(totalSyncCount, start, end);
		}
	}
	
	public static void mergeSort (int [] totalSyncCount, int start, int end) {
		if (start < end) {
			int mid = (start+end)/2;
			Thread t = new Thread(new MergeThread(totalSyncCount, start, mid));
			t.start();
			Thread t2 = new Thread(new MergeThread(totalSyncCount, mid+1, end));
			t2.start();
			try {
				t.join();
				t2.join();
			} catch (InterruptedException e) { }
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
