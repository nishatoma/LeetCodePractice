class MinimumLimitOfBallsInABag {
    
    public int minimumSize(int[] nums, int maxOperations) {
        
        int left = 1, right = 0;
        
        for (int i = 0; i < nums.length; i++) {
            right = right > nums[i] ? right : nums[i];
        }
        
        while (left < right) {
            int mid = (left+right)/2;
            
            int count = 0;
            
            for (int i = 0; i < nums.length; i++) {
                count += (nums[i]-1)/mid;
            }
            
            if (count > maxOperations)  {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}