import java.util.*;

/**
 * This class describes a solution.
 * 
 * @author     Abhiram Rayala
 */
class Solution {


	/**
	 * quick sort
	 *
	 * @param      arr   The arr
	 *
	 * @return     returns the sorted array
	 */
	public static int[] quickSort(final int[] arr) {
		Collections.shuffle(Arrays.asList(arr));
		recursivepartition(arr, 0, arr.length - 1);
		return arr;
	}

	/**
	 * main function for testing
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		int[] num = {9, 1, 2, 6, 8, 7, 34, 11, 8, 3, 46};
		recursivepartition(num, 0, num.length - 1);
		System.out.println(Arrays.toString(num));
	}


	/**
	 * recursive partition funcutin
	 *
	 * @param      arr   The arr
	 * @param      low   The low
	 * @param      high  The high
	 */
	static void recursivepartition(final int[] arr, final int low , final  int high) {
		if (low >= high) return ;
		int pivotIndex = partition(arr, low, high);
		recursivepartition(arr, low, pivotIndex - 1);
		recursivepartition(arr, pivotIndex + 1, high);
	}

	/**
	 * partition function returns the pivot index
	 *
	 * @param      arr   The arr
	 * @param      low   The low
	 * @param      high  The high
	 *
	 * @return     pivot index
	 */
	static int partition(final int[] arr, final int low , final int high) {
		int pivot = low;
		int i = low, j = high + 1;
		while (true) {
			while (arr[pivot] > arr[++i]) {
				if (i == high ) break;
			}
			while (arr[pivot] < arr[--j]) {
				if (j == low ) break;
			}
			if ( i >= j ) break;
			if (arr[i] > arr[j]) swap(arr, i, j);
		}
		swap(arr, pivot, j);
		System.out.println(i + " " + j);
		return j;
	}

	/**
	 * swap the elements
	 *
	 * @param      arr   The arr
	 * @param      a     index a
	 * @param      b     index b
	 */
	static void swap(final int[] arr ,final int a ,final int b ) {
		int temp = arr[b];
		arr[b] = arr[a];
		arr[a] = temp;
	}
}
