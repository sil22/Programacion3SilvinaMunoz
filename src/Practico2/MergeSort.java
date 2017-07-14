package Practico2;

public class MergeSort {
	private int[] numbers;
	private int[] helper;
	private int number;

	public void sort(int[] values) {
		this.numbers = values;
		number = values.length;
		this.helper = new int[number];
		mergesort(0, number - 1);
	}

	private void mergesort(int low, int high) {

		if (low < high) { 		// Check if low is smaller then high, if not then the array is sorted
			int middle = (low + high) / 2; // Get the index of the element which is in the middle
			mergesort(low, middle); // Sort the left side of the array
			mergesort(middle + 1, high); // Sort the right side of the array
			merge(low, middle, high);// Combine them both
		}
	}

	private void merge(int low, int middle, int high) {

		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			helper[i] = numbers[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low; 
		// Copy the smallest values from either the left or the right side back
		//to the original array
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				numbers[k] = helper[i];
				i++;
			} else {
				numbers[k] = helper[j];
				j++;
			}
			k++;
		} 
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			numbers[k] = helper[i];
			k++;
			i++;
		}

	}
	
}