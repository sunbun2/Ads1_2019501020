import java.util.Arrays;
import java.util.Scanner;

class FarthestPair {
    double[] arr;
    FarthestPair (double[] arr) {
        this.arr = arr;
    }

    public double findmax() {
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
    public double findmin() {
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        // double[] a = {1.0,2.9,5.4,2.8,5.4};
        // FarthestPair b = new FarthestPair(a);
        //System.out.println(b.findmax());
        //System.out.println(b.findmin());
        Scanner s = new Scanner(System.in);
        System.out.println("enter the elements of array with spaces");
        String c = s.nextLine();
        s.close();
        String[] arr = c.split(" ");
        double[] arr1 = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            double d = Double.parseDouble(arr[i]);
            arr1[i] = d;
        }
        FarthestPair x = new FarthestPair(arr1);
        double[] ans = {x.findmin(),x.findmax()};
        System.out.println(Arrays.toString(ans));
    }
}

