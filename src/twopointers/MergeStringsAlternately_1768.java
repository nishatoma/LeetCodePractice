package twopointers;

public class MergeStringsAlternately_1768 {
    public String mergeAlternately(String s1, String s2) {
        char[] res = new char[s1.length() + s2.length()];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < s1.length() && j < s2.length()) {
            res[k++] = s1.charAt(i++);
            res[k++] = s2.charAt(j++);
        }

        while (i < s1.length()) {
            res[k++] = s1.charAt(i++);
        }

        while (j < s2.length()) {
            res[k++] = s2.charAt(j++);
        }
        return new String(res);
    }
}
