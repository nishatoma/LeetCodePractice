package twopointers;

public class SortArrayByPartiy_905 {
    public int[] sortArrayByParity(int[] nums) {
        int res[] = new int[nums.length];
        int lo = 0; int hi = nums.length - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                res[lo++] = num;
            } else {
                res[hi--] = num;
            }
        }
        return res;
    }
}
