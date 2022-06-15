package twopointers;

public class ReversePrefixOfAWord_2000 {
    public String reversePrefix(String word, char ch) {
        // make the string into character array
        char[] arr = word.toCharArray();
        // Iterate
        int i = 0;
        int j = 0;
        while (j < arr.length && arr[j] != ch) j++;
        if (j >= word.length()) return word;
        // Otherwise, start reversing
        while (i <= j) {
            char temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
        return new String(arr);
    }
}
