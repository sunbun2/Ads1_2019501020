/*
 *given an array finding the dynamic median of the given array.
 *
 *@author      Abhiram Rayala
 */
class Solution{
	private static double median = 0.0;
	public Solution() {}
	/**
	 * returns the median of the available values
	 *
	 * @param      MinPQ,MaxPQ. 
	 *
	 * @return     median value as double
	 */
    public double median(MinPQ<Double > a,MaxPQ<Double> b){
		if (a.size() == b.size()){
			median=(a.min() + b.max()) / 2;
			return median;
		}  
		else if(b.size() > a.size()) {
			median = b.max();
			return median;
		} 
		else {
			median = a.min();
			return median;
		}
	}
	public static double[] dynamicMedian(double[] arr) {
		MaxPQ<Double> b = new MaxPQ<Double>();                                                                                                                    
		MinPQ<Double> a = new MinPQ<Double>();
		Solution s = new Solution();
		double[] arr1 = new double[arr.length];
		for (int i=0; i < arr.length; i++){
			if (arr[i] >= median){
				a.insert(arr[i]);
			}
			else b.insert(arr[i]);
			if (a.size() - b.size() >  1) {
				double q = a.delMin();
				b.insert(q);
			}
			else if ((b.size() - a.size()) > 1) {
				double m = b.delMax();
				a.insert(m);
			}
			arr1[i] = s.median(a, b);
		}
		return arr1;
	}
}
