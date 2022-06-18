package twopointers;

import java.util.Arrays;

public class KStrongestValueInArray_1471 {
    public int[] getStrongest(int[] arr, int k) {
        // Sort the array
        Arrays.sort(arr);
        // Find median, 
        int median = arr[(arr.length - 1) / 2];
        // result array
        int[] res = new int[k];
        // Iterate
        int i = 0;
        int j = arr.length - 1;
        while (k-- != 0) {
            // Condition for "stronger" element
            if (Math.abs(median - arr[i]) > Math.abs(median - arr[j])) {
                res[k] = arr[i++];
            } else {
                res[k] = arr[j--];
            }
        }
        return res;
    }
}
