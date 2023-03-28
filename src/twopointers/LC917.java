package twopointers;

public class LC917 {
    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int lo = 0;
        int hi = arr.length - 1;

        while (lo < hi) {
            if (isLetter(arr[lo]) && isLetter(arr[hi])) {
                swap(lo++, hi--, arr);
            } else if (isLetter(arr[lo])) {
                --hi;
            } else if (isLetter(arr[hi])) {
                ++lo;
            } else {
                --hi;
                ++lo;
            }
        }
        return new String(arr);
    }

    private void swap(int i, int j, char[] arr) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private boolean isLetter(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }
}
