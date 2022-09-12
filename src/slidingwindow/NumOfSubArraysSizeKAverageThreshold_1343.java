package slidingwindow;

public class NumOfSubArraysSizeKAverageThreshold_1343 {

    public int numOfSubarrays(int[] arr, int k, int t) {
        int n = arr.length;
        int l = 0;
        int res = 0;
        int sum = 0;

        for (int r = 0; r < n; ++r) {
            sum += arr[r];
            // If size of window reached K, do the needful
            if (r - l + 1 == k) {
                if (sum / k >= t) res++;
                sum -= arr[l++];
            }
        }
        return res;
    }
}
