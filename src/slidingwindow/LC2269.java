package slidingwindow;

public class LC2269 {
    public int divisorSubstrings(int num, int k) {
        int sub = 0;
        int res = 0;
        int copy = num;
        int pow = 1;
        while (copy > 0) {
            sub += (copy % 10) * pow;
            // Check boundary
            if (--k > 0) {
                // we have not reached the boundary yet,
                // we can keep going..
                pow *= 10;
            } else {
                // Check now for condition
                if (sub != 0 && num % sub == 0) ++res;
                sub /= 10;
            }
            copy /= 10;
        }
        return res;
    }
}
