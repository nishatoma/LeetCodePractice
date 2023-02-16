package twopointers;

public class Leetcode_167 {
    public int[] twoSum(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            if (arr[lo] + arr[hi] < target) lo++;
            else if (arr[lo] + arr[hi] > target) hi--;
            else return new int[]{lo + 1, hi + 1};
        }
        return new int[]{-1, -1};
    }
}
