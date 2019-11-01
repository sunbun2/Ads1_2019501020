import java.util.Arrays;

class Solution{
	public static void swap(int i,int j, int[] arr) {
		int temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public int[] sortInsertion(int[] arr){
		// fill you code Here
		for (int i=1 ; i<arr.length;i++) {
			for (int j=i-1;j>=0;j--){
				System.out.println(Arrays.toString(arr));
				if (arr[j]>arr[i]){
					Solution.swap(j,i,arr);
				}
			}
		}

		return arr;
	}
	public int[] sortSelection(int[] arr){
		// fill you code Here
		for (int i:arr) {

		}
		return null;
	}

	public static void main (String[] args) {
		int[] a= {9, 2, 5, 6,3};
		Solution b= new Solution();
		int[] c=b.sortInsertion(a);
		System.out.println(Arrays.toString(c));
	}
}