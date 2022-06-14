package twopointers;

public class RearrangeArrayElementsBySign_2149 {
    public int[] rearrangeArray(int[] nums) {
        // Idea is to keep two pointers,
        // one starts at 0, the other starts at 1
        // increment each pointer by 2 depending if
        // the number we get is positive or negative
        int posIndex = 0;
        int negIndex = 1;
        // Make a result array
        int[] arr = new int[nums.length];
        // iterate
        for (int num : nums) {
            if (num >= 0) {
                arr[posIndex] = num;
                posIndex += 2;
            } else {
                arr[negIndex] = num;
                negIndex += 2;
            }
        }
        return arr;
    }
}
