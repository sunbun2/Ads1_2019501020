
import java.util.*;

class Solution {

	static int count = 0;

	static void splitting(String[] arr, String[] newarr , int low , int high) {
		if (low == high) {
			System.out.println("low is " + low + " high is " + high);
			newarr[low] = arr[low];
			System.out.println("2nd arry is " + Arrays.toString(newarr));
			return;
		}
		int mid = low  + (high - low) / 2;
		System.out.println("spliting " + low + "from" + high + "medium at " + mid);
		splitting(arr, newarr, low, mid);
		splitting(arr, newarr, mid + 1, high);
		merge(arr, newarr, low, mid, high);
	}



	static void merge(String[] arr, String[] newarr, int low, int mid , int high ) {
		System.out.println("merging");
		// System.out.println("merging");
		for (int k = low; k <= high; k++) {
			newarr[k] = arr[k];
		}
		int i = low, j = mid + 1;
		for (int k = low; k <= high; k++) {
			if      (i > mid)              arr[k] = newarr[j++];
			else if (j > high)               arr[k] = newarr[i++];
			else if ( newarr[j].compareTo(newarr[i]) <= 0) arr[k] = newarr[j++];
			else                           arr[k] = newarr[i++];
		}

		System.out.println(Arrays.toString(newarr));


		// int m = low , j = mid + 1 , track = low;
		// while (m < mid || j < high) {
		// 	if (arr[m].compareTo(arr[j]) == -1) newarr[track++] = arr[m++];
		// 	else newarr[track++] = arr[j++];
		// }
		// System.out.println(Arrays.toString(newarr));


		// for (int i = low ; i <= high; i++) {
		// 	if (arr[m].compareTo(arr[j]) == -1) newarr[track++] = arr[m++];
		// 	else newarr[track++] = arr[j++];
		// 	System.out.println(track + "<= " + m + "/" + j);
		// 	System.out.println(Arrays.toString(newarr));
		// }
		// System.out.println(mid - low + 1 + " " + (high - mid));
		// int i = 0;
		// int counter = len1 > len2 ? len2 : len1;
		// while (i < counter ) {
		// 	if (arr[m].compareTo (arr[j]) == -1) {
		// 		newarr[track++] = arr[m++];
		// 	} else {
		// 		newarr[track++]  = arr[j++];
		// 	}
		// }
		// while (i < len1) {
		// 	newarr[track++] = arr[m++];
		// }
		// while (i < len2) {
		// 	newarr[track++ ] = arr[j++];
		// }


		/*
		System.out.println("merge at " + (count++) + " merge " + Arrays.toString(newarr));
		//sort 2 arrays from indexes and sort
		// int mid = (high + low) / 2;
		System.out.println(low + " " + high + " " + mid);
		// int track = low , arr1track = low , arr2track = mid+1;
		// for (int i = low ; i < high ; i++ ) {

		// }

		int i = low , j = mid + 1 , k = low;
		int n1 = mid - low + 1 , n2 = high - mid;
		System.out.println(n1 + "" + n2);
		while (i < n1 && j < n2) {
			if (arr[i].compareTo(arr[j])  == -1)
				newarr[k++] = arr[i++];
			else
				newarr[k++] = arr[j++];
		}
		while (i < n1)
			newarr[k++] = arr[i++];
		while (j < n2)
			newarr[k++] = arr[j++];

		// System.out.println(lenarr1 + "  " + lenarr2 + " " + i + " " + (j - i) );
		// while (i < lenarr1 && (j - i)-1 < lenarr2 ) {
		// 	System.out.println(i + " " + j);
		// 	if (arr[i].compareTo(arr[j]) == -1 ) newarr[k++] = arr[i++];
		// 	else newarr[k++] = arr[j++];
		// }
		// while (i < lenarr2) newarr[k++] = arr[i++];
		// while ((j - i)< lenarr2 ) newarr[k++] = arr[j++];
		System.out.println(Arrays.toString(newarr));
		*/
	}

	public static String[] mergeSort(String[] arr) {
		String[] newarr = new String[arr.length];
		splitting(arr, newarr, 0, newarr.length - 1);
		return arr;
	}

	public static void main(String[] args) {
		String[] ele = {"5", "2" , "1" , "4"};
		mergeSort(ele);
		System.out.println(Arrays.toString(ele));
	}

}