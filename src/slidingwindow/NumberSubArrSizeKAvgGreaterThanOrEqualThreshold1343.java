package slidingwindow;

class NumberSubArrSizeKAvgGreaterThanOrEqualThreshold1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        int n = arr.length;

        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            sum += arr[i];
            cnt++;
            if (cnt == k) {
                if (sum / k >= threshold) {
                    res++;
                }
                sum -= arr[i - (k - 1)];
                cnt -= 1;
            }
        }

        return res;
    }
}
