package bitmanipulation;

public class LC2220 {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int count = 0;
        while (xor > 0) {
            xor &= (xor - 1);
            ++count;
        }
        return count;
    }
}
