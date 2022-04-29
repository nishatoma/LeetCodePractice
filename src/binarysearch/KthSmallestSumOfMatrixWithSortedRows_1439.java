package binarysearch;

public class KthSmallestSumOfMatrixWithSortedRows_1439 {

    private int[][] mat;
    private int m;
    private int n;

    public int kthSmallest(int[][] mat, int k) {
        this.mat = mat;
        this.m = mat.length;
        this.n = mat[0].length;

        int low = 0;
        int high = 0;

        for (int i = 0; i < m; i++) {
            low += mat[i][0];
            high += mat[i][n - 1];
        }
        int init = low;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = dfs(mid, 0, init, k);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int dfs(int mid, int index, int sum, int k) {
        if (index == m) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (sum + mat[index][i] - mat[index][0] <= mid) {
                count += dfs(mid, index + 1, sum + mat[index][i] - mat[index][0], k);
                if (count >= k) {
                    return count;
                }
            } else {
                break;
            }
        }

        return count;
    }

}
