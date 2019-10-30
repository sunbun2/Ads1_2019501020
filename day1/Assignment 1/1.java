import java.util.Arrays;

class threesum {
    int[] arr;
    int count;
    public threesum(int[] arr) {
        this.count=0;
        Arrays.sort(arr);
        this.arr=arr;
    }
    
    public int implement(){
        for (int i=0;i<arr.length;i++){
            
            for (int j=i+1;j<arr.length;j++){
                if ((Arrays.binarySearch(arr, -(arr[i]+arr[j]))>0) && (i!=j)){
                    if (arr[i]<arr[j]){
                        if (arr[j]<(-(arr[i]+arr[j]))){
                            this.count=this.count+1;
                        }
                    }
                   
                }
            }
        }
        return this.count;
    }
    public static void main(String[] args){
        int[] intArray = new int[]{30,-40,-20,-10,40,0,10,5}; 
        threesum a = new threesum(intArray);
        int c = a.implement();
        System.out.println(c);
    }
}