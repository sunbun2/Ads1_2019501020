/*
 *given N integers , how many triples sum to excatly zero
 *
 *
 *@author      Abhiram Rayala
 *
 *8
 *30 -40 -20 -10 40 0 10 5
 *answer 4
 */

import java.util.*;


/**
 * This class describes triples.
 */
class Triples {

	/**
	 * binary search the element in array
	 *
	 * @param      elements  The elements
	 * @param      value     The value
	 *
	 * @return     integer representing the index
	 */
	static int binarySearch(int[] elements , final int value ) {
		int lo = 0 , hi = elements.length - 1;
		while (lo <= hi) {
			int mid = (hi + lo) / 2;
			if (value < elements[mid]) hi = mid - 1;
			else if(value > elements[mid]) lo = mid + 1 ;
			else return mid;
		}
		return - 1;
	}



	/**
	 * function to show the triplets in array
	 *
	 * @param      elements  The elements
	 */
	static void triples(int[] elements) {
		Arrays.sort(elements);
		for (int i = 0 ; i < elements.length ; i++) {
			for (int j = i ; j < elements.length ; j++) {
				int remain = (elements[i] + elements[j]) * (-1) ;
				int index = binarySearch(elements, remain);
				if (index != -1 && elements[i] < elements[j] &&
				        elements[j] < elements[index]) {
					System.out.println(elements[i] + " " + elements[j] + " " + elements[index]);
				}
			}
		}

	}


	/**
	 * main function
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		// int[] e ={1,2};
		triples(new int[] { 30, -40, -20, 40, -10, 0, 10, 5 });
	}

}
