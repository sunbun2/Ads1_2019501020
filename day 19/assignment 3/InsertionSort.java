import java.util.*;


/**
 * This class describes a solution.
 *
 * @author Abhiram Rayala
 */

class InsertionSort {

	/**
	 * sorts the array using insertion sort
	 *
	 * @param      arr   The arr
	 *
	 * @return     sorted array
	 */
	public String[] sortInsertion(final String[] arr) {
		for (int j = 1; j < arr.length; j++) {
			int key = arr[j];
			int i = j - 1;
			while (i >= 0 && key < arr[i]) {
				arr[i + 1] = arr[i];
				i--;
			}
			arr[i + 1] = key;
		}
		return arr;
	}

	/**
	 * sorts the elemetns in selection alg
	 *
	 * @param      arr   The arr
	 *
	 * @return     sorted array
	 */
	public int[] sortSelection(final int[] arr) {
		for (int i = 0; i < arr.length ; i++) {
			int minIndex = i;
			for (int j = i + 1 ; j < arr.length ; j++) {
				if ( arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
		return arr;
	}

	/**
	 * swaps the element
	 *
	 * @param      arr       The arr
	 * @param      current   The current
	 * @param      minIndex  The minimum index
	 */
	static void swap(final int[] arr, final int current, final  int minIndex ) {
		int temp = arr[current];
		arr[current] = arr[minIndex];
		arr[minIndex] = temp;
	}

}