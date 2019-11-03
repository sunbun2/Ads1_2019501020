/**
 *@author      Abhiram Rayala
 * This class describes a solution.
 */
final class Solution {

    /**
     * Constructs a new instance.
     */
    private Solution() {
        //not called
    }

    /**.
     * Josephus solutions
     *
     * @param      a     total number of seats
     * @param      b     step wise
     *
     * @return     Returns the elements in String
     */
    public static String Josephus(final int a, final int b) {
        CircularList list = new CircularList();
        for (int i = 0 ; i < a; i++) {
            list.add(Integer.toString(i));
        }
        return list.removeStep(b);
    }


}
