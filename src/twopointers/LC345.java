package twopointers;

public class LC345 {
    public String reverseVowels(String s) {
        int lo = 0;
        int hi = s.length() - 1;
        char[] arr = s.toCharArray();
        while (lo < hi) {
            if (isVowel(arr[lo]) && isVowel(arr[hi])) {
                swap(lo++, hi--, arr);
            } else if (isVowel(arr[lo])) {
                --hi;
            } else if (isVowel(arr[hi])) {
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

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'A') return true;
        if (c == 'e' || c == 'E') return true;
        if (c == 'i' || c == 'I') return true;
        if (c == 'o' || c == 'O') return true;
        if (c == 'u' || c == 'U') return true;
        return false;
    }
}
