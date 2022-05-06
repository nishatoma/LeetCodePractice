class MinimumNumberOfDaysToMakeMBouqets_1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int lo = 1, hi = max(bloomDay);
        int res = -1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (isPossible(bloomDay, m, k, mid)) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return res;
    }
    
    private int max(int[] arr) {
        int max = 0;
        
        for (int num: arr) max = Math.max(max, num);
        
        return max;
    }
    
    private boolean isPossible(int[] days, int m, int k, int day) {
        int count = 0, total = 0;
        
        for (int bday: days) {
            if (bday <= day) {
                count++;
                if (count >= k) {
                    total++;
                    count = 0;
                    if (total == m) {
                        return true;
                    }
                }
            } else {
                count = 0;
            }
        }
        
        return false;
    }
}