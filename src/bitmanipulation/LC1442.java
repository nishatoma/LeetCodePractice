package bitmanipulation;

public class LC1442 {
    public int countTriplets(int[] arr) {
        // Basically, since we need a == b,
        // we just need to find all XOR pairs such that a ^ b == 0...
        int ans = 0;
        int n = arr.length;

        for (int i = 0; i < n; ++i) {
            int xor = arr[i];

            for (int j = i + 1; j < n; ++j) {
                xor ^= arr[j];
                if (xor == 0) {
                    ans += j - i;
                }
            }
        }
        return ans;
    }
}
