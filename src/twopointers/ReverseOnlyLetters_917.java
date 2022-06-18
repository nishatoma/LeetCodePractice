package twopointers;

public class ReverseOnlyLetters_917 {
    public String reverseOnlyLetters(String s) {
        // String builder approach
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (!Character.isLetter(s.charAt(i))) {
                i++;
            } else if (!Character.isLetter(s.charAt(j))) {
                j--;
            } else {
                sb.setCharAt(i, s.charAt(j));
                sb.setCharAt(j--, s.charAt(i++));
            }
        }
        return sb.toString();
    }
}
