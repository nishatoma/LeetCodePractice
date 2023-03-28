package twopointers;

public class LC680 {
    public boolean validPalindrome(String s) {
        int lo = 0;
        char[] arr = s.toCharArray();
        int hi = arr.length - 1;

        while (lo < hi) {
            if (arr[lo] != arr[hi]) {
                return isPalindrome(lo, hi - 1, arr) || isPalindrome(lo + 1, hi, arr);
            }
            ++lo;
            --hi;
        }
        return true;
    }

    private boolean isPalindrome(int i, int j, char[] arr) {
        while (i < j) {
            if (arr[i] != arr[j]) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }
}
