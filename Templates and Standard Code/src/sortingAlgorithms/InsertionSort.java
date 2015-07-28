package sortingAlgorithms;

import java.util.Random;

public class InsertionSort {
	public static void main(String [] args) {
		int [] arrayToSort = new int[5];
		int domain = 100;
		generateArray(arrayToSort, domain);
		System.out.print("Before: ");
		printArray(arrayToSort);
		inSort(arrayToSort);
		System.out.print("After: ");
		printArray(arrayToSort);
	}
	
	public static void printArray(int [] arrayToSort) {
		for (int i = 0; i < arrayToSort.length; i++) {
			System.out.print(arrayToSort[i] + " ");
		}
		System.out.println();
	}
	
	public static void generateArray(int [] arrayToSort, int domain) {
		Random rand = new Random(System.currentTimeMillis());
		for (int i = 0; i < arrayToSort.length; i++) {
			arrayToSort[i] = rand.nextInt(domain)+1;
		}
	}
	
	//sorts in place. input is a filled array that needs to be sorted
	public static void inSort(int [] arrayToSort) {
		int switchNum, j;
		for (int i = 1; i < arrayToSort.length; i++) {
			switchNum = arrayToSort[i];
			j = i-1;
			while (j >= 0 && switchNum < arrayToSort[j]) {
				arrayToSort[j+1] = arrayToSort[j];
				j--;
			}
			arrayToSort[j+1] = switchNum;
		}
	}
}
