package bitmanipulation;

public class LC1486 {
    public int xorOperation(int n, int start) {
        int res = start;
        for (int i = 1; i < n; ++i) {
            int numAtI = start + 2 * i;
            res = res ^ numAtI;
        }
        return res;
    }
}
