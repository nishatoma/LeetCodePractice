class SingleElementInSortedArray_540 {
    public int singleNonDuplicate(int[] nums) {
        
        int lo = 0, hi = nums.length - 1;
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (nums[mid] == nums[mid ^ 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        
        return nums[lo];
    }
}