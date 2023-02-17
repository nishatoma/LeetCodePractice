package twopointers;

public class Leetcode_42 {
    public int trap(int[] height) {
        // get total
        int res = 0;
        int len = height.length;
        int left = 0, right = len - 1, maxLeft = 0, maxRight = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                // Move from the left
                // If we find a taller height, just update max,
                // We hit a taller wall, cannot trap
                if (height[left] >= maxLeft) maxLeft = height[left];
                else res += maxLeft - height[left];
                ++left;
            } else {
                // Same thing here
                if (height[right] >= maxRight) maxRight = height[right];
                else res += maxRight - height[right];
                // Move from the right
                --right;
            }
        }
        return res;
    }
}
