package slidingwindow;

public class LC1652 {
    public int[] decrypt(int[] code, int k) {
        // Basically, depending if K is positive or negative
        // Just place the window either at the start or at the end lol...
        int len = code.length;
        int[] res = new int [len];
        // Neutral case
        if (k == 0) return res;
        // Otherwise, we need to define window now
        int start = 1, end = k, sum = 0;
        // If k is negative, just reverse..
        if (k < 0) {
            k = -k;
            start = len - k;
            end = len - 1;
        }
        // Add the initial sum..
        for (int i = start; i <= end; ++i) {
            sum += code[i];
        }
        // now iterare and assign the result to res array
        for (int i = 0; i < len; ++i) {
            res[i] = sum;
            // Move both windows
            sum -= code[(start++) % len];
            sum += code[(++end) % len];
        }
        return res;
    }
}
