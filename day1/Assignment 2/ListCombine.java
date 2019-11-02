import java.util.Arrays;

class ListCombine {
    int[] arr1;
    int[] arr2;
    int[] arr3;
    private int i;/** Varibale for iteration */ 
    private int j; /** Varibale for iteration */
    private int k;/** Varibale for iteration */
    public ListCombine(final int[] arr1 , final int[] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.x = arr1.length + arr2.length;
        this.arr3 = new int[this.x];
        this.j = 0;
        this.i = 0;
        this.k = 0;

    } 
    public int[] combine() {
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr3[k] = arr1[i];
                k += 1;
                i += 1;
            }
            else {
                arr3[k] = arr2[j];
                k += 1;
                j += 1;
            }
        }

        while (j < arr2.length) {
            arr3[k] = arr2[j];
            k += 1;
            j += 1;
        }

        while (i < arr1.length) {
            arr3[k] = arr1[i];
            k += 1;
            i += 1;
        }
        return arr3;
    }

    public static void main(String[] args) {
       int[] q = {1,3,5,7};
       int[] r = {8,9,10,11};
        ListCombine abc = new ListCombine(q,r);
        int[] s = abc.combine();
        System.out.println(Arrays.toString(s));
    }
}
