
/*
 *given an array checking whether the array is in min heap or not. 
 *@author      Abhiram Rayala
 */
class Solution{
	public Solution() { }
	/**
	 * checking if the array is in min
	 *
	 * @param      arr  array of the elements
	 *
	 * @return     integer 0 or 1.
	 */
	public int method(final double[] arr) {
		if (arr.length == 0) {
			return 0;
		}
		else if ( arr.length == 1) {
			return 1;
		}
		if (arr.length == 2){
			if (arr[0] < arr[1]) {
				return 1;
			} 
			else {
				return 0;
			}
		}
		for (int i = 0; i < (arr.length / 2); i++) {
			if (arr[i] > arr[2 * i]) return 0;
			if (arr[i] > arr[2 * i + 1]) return 0;
		}
		return 1;
	}
	public static boolean isMinHeap(double[] arr){
		Solution a = new Solution();
		if (a.method(arr) == 1) {
			return true;
		}
		return false;
	}
}
