import java.util.Arrays;

class LearningByDoing {
    int checkpairs(int[] arr) {
        int count = 0;
        Arrays.sort(arr);
        for (int i=0 ; i < arr.length-1 ; i++) {
            if (arr[i] == arr[i+1]) {
                count++;
            }
        }
        return count;
    }
}