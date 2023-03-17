package bitmanipulation;

public class LC1342 {
    public int numberOfSteps(int num) {
        int cur = num;
        int res = 0;
        while (cur != 0) {
            if ((cur & 1) == 0) {
                cur >>= 1;
            } else {
                cur ^= 1;
            }
            ++res;
        }
        return res;
    }
}
