package sortingAlgorithms;

public class ConcurrentQuickSort {
	public static void main (String [] args) {
		int [] quickArray = new int[10000];
		createArray.randomizedIntArray(quickArray,100);
		for (int i = 0; i < quickArray.length; i++) {
			System.out.print(quickArray[i] + " ");
		}
		System.out.println();
		long start = System.currentTimeMillis();
		Thread t = new Thread(new QuickThread(quickArray, 0, quickArray.length-1));
		t.start();
		try {
			t.join();
			long time = System.currentTimeMillis() - start;
			System.out.println("time: " + time);
		} catch (InterruptedException e) { }
		for (int i = 0; i < quickArray.length; i++) {
			System.out.print(quickArray[i] + " ");
		}
		System.out.println();
	}
	
	static class QuickThread implements Runnable {
		int [] quickArray;
		int start;
		int end;
		public QuickThread(int [] quickArray, int start, int end) {
			this.quickArray = quickArray;
			this.start = start;
			this.end = end;
		}
		
		public void run() {
			quickSort(quickArray,start,end);
		}
		
	}
	
	public static void quickSort (int [] quickArray, int start, int end) {
		if (start < end) {
			int mid = partition(quickArray, start, end);
			Thread t = new Thread(new QuickThread(quickArray,start,mid-1));
			Thread t2 = new Thread(new QuickThread(quickArray,mid+1,end));
			t.start();
			t2.start();
			try {
				t.join();
				t2.join();
			} catch (InterruptedException e) { }
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
