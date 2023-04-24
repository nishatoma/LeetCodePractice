package bitmanipulation;

public class LC2317 {
    public int maximumXOR(int[] nums) {
        // OR all the bits to get maximum XOR
        int ans = 0;
        for (int num : nums) {
            ans |= num;
        }
        return ans;
    }
}
