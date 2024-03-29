package bitmanipulation;

public class LC338 {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i < n + 1; ++i) {
            ans[i] = getBits(i);
        }
        return ans;
    }

    private int getBits(int num) {
        int count = 0;

        while (num > 0) {
            count += (num & 1);
            num = num >> 1;
        }
        return count;
    }
}
