package stack;

public class LC1111 {
    public int[] maxDepthAfterSplit(String seq) {
        // Basically, make sure we put each depth (odd/even) into its own group.
        int[] groups = new int[seq.length()];
        int depth = 0;
        for (int i = 0; i < groups.length; ++i) {
            if (seq.charAt(i) == '(') {
                groups[i] = ++depth % 2;
            } else {
                groups[i] = depth-- % 2;
            }
        }
        return groups;
    }
}
