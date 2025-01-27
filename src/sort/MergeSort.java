/**
 * Copyright 2020 jingedawang
 */
package sort;

import utils.ArrayGenerator;
import utils.ArrayPrinter;
import utils.TimeRecorder;

/**
 * <h3>Merge sort algorithm</h3>
 */
public class MergeSort implements Sort {

	/**
	 * Test code.
	 */
	public static void main(String[] args) {
		int[] arr = ArrayGenerator.fixedArray();
//		int[] arr = ArrayGenerator.randomArray(20, 20);
		ArrayPrinter.print(arr);

		MergeSort sort = new MergeSort();
		TimeRecorder timeRecorder = new TimeRecorder();
		timeRecorder.start();
		sort.sort(arr);
		timeRecorder.stop();
		timeRecorder.showElapsedTime();

		ArrayPrinter.print(arr);
	}

	/**
	 * Merge sort.
	 *
	 * @param arr Integer array to be sorted.
	 */
	@Override
	public void sort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	/**
	 * Merge sort a subarray recursively.
	 *
	 * @param arr The integer array where the subarray resides.
	 * @param p   The start index of the subarray to be sorted.
	 * @param r   The end index(included) of the subarray to be sorted.
	 */
	private void mergeSort(int[] arr, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(arr, p, q);
			mergeSort(arr, q + 1, r);
			merge(arr, p, q, r);
		}
	}

	/**
	 * Merge the two sorted subarray.
	 *
	 * @param arr The integer array where the two sorted subarrays reside.
	 * @param p   The start index of the first subarray.
	 * @param q   The end index(included) of the first subarray.
	 * @param r   The end index(included) of the second subarray. Note that the start index of the second subarray is
	 *            always the next position of the end of the first subarray.
	 */
	protected void merge(int[] arr, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] arrL = new int[n1 + 1];
		int[] arrR = new int[n2 + 1];
		for (int i = 0; i < n1; i++) {
			arrL[i] = arr[p + i];
		}
		for (int i = 0; i < n2; i++) {
			arrR[i] = arr[q + 1 + i];
		}
		arrL[n1] = Integer.MAX_VALUE;
		arrR[n2] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		for (int k = p; k <= r; k++) {
			if (arrL[i] <= arrR[j]) {
				arr[k] = arrL[i];
				i++;
			} else {
				arr[k] = arrR[j];
				j++;
			}
		}
	}

}