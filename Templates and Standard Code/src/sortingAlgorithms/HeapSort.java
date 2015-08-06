package sortingAlgorithms;

public class HeapSort {
	
	public static int heapSize = 0;
	
	public static void main(String [] args) {
		int [] heapArray = new int[5];
		createArray.randomizedIntArray(heapArray,100);
		for (int i = 0; i < heapArray.length; i++) {
			System.out.print(heapArray[i] + " ");
		}
		System.out.println();
		long start = System.currentTimeMillis();
		heapSort(heapArray, 0, heapArray.length-1);
		long time = System.currentTimeMillis() - start;
		System.out.println("time: " + time);
		for (int i = 0; i < heapArray.length; i++) {
			System.out.print(heapArray[i] + " ");
		}
		System.out.println();
	}
	
	public static void heapSort(int [] heapArray, int start, int end) {
		buildMaxHeap(heapArray);
		for (int i = heapArray.length-1; i >= 1; i--) {
			swap(heapArray, 0, i);
			heapSize = heapSize - 1;
			maxHeapify(heapArray, 0);
		}
	}
	
	public static void buildMaxHeap (int [] heapArray) {
		heapSize = heapArray.length;
		for (int i = heapArray.length/2; i >= 0; i--) {
			maxHeapify(heapArray, i);
		}
	}
	
	public static int maxHeapify (int [] heapArray, int i) {
		int l = left(i);
		int r = right(i);
		int largest;
		if (l <= heapSize && heapArray[l] > heapArray[i]) {
			largest = l;
		} else {
			largest = i;
		}
		if (r <= heapSize && heapArray[r] > heapArray[largest]) {
			largest = r;
		}
		if (largest != i) {
			swap(heapArray, i, largest);
			maxHeapify(heapArray, largest);
		}
		return 0;
	}
	
	public static void swap (int [] heapArray, int i, int largest) {
		int temp = heapArray[largest];
		heapArray[largest] = heapArray[i];
		heapArray[i] = temp;
	}
	
	public static int parent (int i) {
		return i/2;
	}
	
	public static int left (int i) {
		return 2*i;
	}
	
	public static int right (int i) {
		return left(i)+1;
	}
}
