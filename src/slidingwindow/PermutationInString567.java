package slidingwindow;

public class PermutationInString567 {

    public static void main(String[] args) {
        boolean t = checkInclusion("abc", "ccccbbbbaaaa");
        System.out.println(t);
    }

    public static boolean checkInclusion(String s1, String s2) {

        int[] map = new int[26];

        for(char c : s1.toCharArray()) map[c - 'a']++;

        int r = 0, l = 0;

        int count_chars = s1.length();

        while(r < s2.length()){

            if(map[s2.charAt(r++) - 'a']-- > 0) {
                count_chars--;
            }

            if(count_chars == 0) return true;

            if(r - l == s1.length() && map[s2.charAt(l++) - 'a']++ >= 0)
                count_chars++;
        }
        return false;
    }
}
