package twopointers;

public class ReverseWordsInAStringIII_557 {

    public String reverseWords(String s) {
        char[] arr = s.toCharArray();

        for (int i = 0, j = 0; i < arr.length && j < arr.length;) {
            while (j < arr.length && arr[j] != ' ') {
                j++;
            }
            for (int q = i, p = j - 1; q < p; q++, p--) {
                char temp = arr[q];
                arr[q] = arr[p];
                arr[p] = temp;
            }
            i = j + 1;
            j++;
        }
        return new String(arr);
    }
}
