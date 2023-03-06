package binarysearch;

public class LC2358 {
    public int maximumGroups(int[] grades) {
        return (int) (Math.sqrt(1 + 8 * grades.length) - 1) / 2;
    }
}
