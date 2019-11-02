import java.util.*;

/**
 * Thighs class describes a solution.
 *
 * @author     Abhiram Rayala
 */
class Solution {

	/**
	 * Sort function
	 *
	 * @param      a     the array
	 * @param      aux   The auxiliary
	 * @param      low    The lowwer
	 * @param      high    The highgher
	 */
	private static void sort(final String[] arr, final  String[] newarr, final  int low, final int high) {
		if (high <= low) return;
		int mid = low + (high - low) / 2;
		sort(arr, newarr, low, mid);
		sort(arr, newarr, mid + 1, high);
		merge(arr, newarr, low, mid, high);
	}

	/**
	 * merges the both sub list arrays to list
	 *
	 * @param      arr     The arr
	 * @param      newarr  The newarr
	 * @param      low     The low
	 * @param      mid     The middle
	 * @param      high    The high
	 */
	private static void merge(final String[] arr, final  String[] newarr, final int low, final int mid, final int high) {
		for (int k = low; k <= high; k++) {
			newarr[k] = arr[k];
		}
		int i = low, j = mid + 1;
		for (int k = low; k <= high; k++) {
			if      (i > mid)              arr[k] = newarr[j++];
			else if (j > high)               arr[k] = newarr[i++];
			else if (newarr[j].compareTo(newarr[i]) <= 0) arr[k] = newarr[j++];
			else                           arr[k] = newarr[i++];
		}
	}



	/**
	 * sorts the array using merge sort
	 *
	 * @param      arr   The arr
	 *
	 * @return     sorted array
	 */
	public static String[]  mergeSort(final String[] arr) {
		String[] newarr = new String[arr.length];
		sort(arr, newarr, 0, arr.length - 1);
		return arr;
	}
}
