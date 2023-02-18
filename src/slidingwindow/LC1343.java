package slidingwindow;

public class LC1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        // Idea is same, fixed size window basically
        // As soon as we reach k elements, we take average
        // and compare to threshold. After k elements, we move the
        // window
        // Get a sum first
        long sum = 0;
        int len = arr.length;
        for (int i = 0; i < len; ++i) {
            // get the sum
            sum += arr[i];
            // Check if we have more than k elements here
            if (i - k >= 0) {
                // Move window
                sum -= arr[i - k];
            }
            // Check if we have then k elements exactly or more
            if (i - k + 1 >= 0) {
                // take the average
                int avg = (int) sum / k;
                if (avg >= threshold) ++res;
            }
        }
        return res;
    }
}
