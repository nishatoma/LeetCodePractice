package stack;

public class LC921 {
    public int minAddToMakeValid(String s) {
        int rightCount = 0;
        int leftCount = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                ++leftCount;
            } else {
                if (leftCount > 0) {
                    --leftCount;
                } else {
                    ++rightCount;
                }
            }
        }
        return leftCount + rightCount;
    }
}
