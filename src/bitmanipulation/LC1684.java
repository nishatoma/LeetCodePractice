package bitmanipulation;

public class LC1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        int mask = 0;
        for (int i = 0; i < allowed.length(); ++i) {
            mask |= (1 << (allowed.charAt(i) - 'a'));
        }

        int count = 0;
        outer:
        for (int i = 0; i < words.length; ++i) {
            boolean based = true;
            for (char c : words[i].toCharArray()) {
                if ((1 << (c - 'a') & mask) == 0) {
                    continue outer;
                }
            }
            if (based) ++count;
        }
        return count;
    }
}
