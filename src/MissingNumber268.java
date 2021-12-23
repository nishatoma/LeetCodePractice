public class MissingNumber268 {


    public int missingNumber(int[] nums) {

        // O(N) solution
        // calculate sum from 0..n using the formula
        // sum all elements in the array
        // subtracting our array sum from summation formula sum will give us hte missing #
        int n = nums.length;
        int summationFromZeroToN = (n * (n + 1)) / 2;
        int arraySum = 0;

        // Add up all the numbers in array
        for (int num : nums) {
            arraySum += num;
        }
        // The result is the difference between our formula sum
        // and the array sum!
        return summationFromZeroToN - arraySum;
    }
}
