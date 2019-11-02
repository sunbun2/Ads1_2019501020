import java.util.Arrays;

/** @author Abhiram Rayala */

class Threesum {
    /** Arrays given as input.*/ 
    private int[] arr; 
    /**Denotes the count of threesum values. */ 
    private int count; 
    public static final int A = 30;   /**input 1 */ 
    public static final int B = -40;  /**input 2 */ 
    public static final int C = -20;  /**input 3 */ 
    public static final int D = -10;  /**input 4 */ 
    public static final int E = 40;   /**input 5 */ 
    public static final int F = 0;    /**input 6 */ 
    public static final int G = 10;   /**input 7 */ 
    public static final int H = 5;    /**input 8 */ 
    
    public Threesum (final int[] arr) {
         /** Parametric Constructer where arr - array of numbers.  */ 
        this.count = 0;
        Arrays.sort(arr);
        this.arr = arr;
    }
 /**This method takes array as input returns integer value
  * The integer value denotes the number of threesum values present in the array
  @return returns integer value count  */ 
 
    public int implement() {
        for (int i = 0 ; i < arr.length ; i++) {
            for (int j = i + 1 ; j < arr.length ; j++) {
                if ((Arrays.binarySearch(arr, -(arr[i] + arr[j])) > 0) && (i != j)) {
                    if (arr[i] < arr[j]) {
                        if (arr[j] < (-(arr[i] + arr[j]))) {
                            this.count = this.count + 1; 
                        }
                    }
                }
            }
        }
        return this.count;
    }

    /** Main method */ 
    public static void main(String[] args) {
        int[] intArray = new int[]{A , B , C , D , E , F , G , H}; 
        Threesum a = new Threesum(intArray);
        int c = a.implement();
        System.out.println(c);
    }
}
