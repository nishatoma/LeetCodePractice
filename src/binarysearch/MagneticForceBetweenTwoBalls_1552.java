import java.util.Arrays;

class MagneticForceBetweenTwoBalls_1552 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int lo = 1, hi = position[position.length - 1];
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (isValid(position, mid, m)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        
        return lo - 1;
    }
    
    private boolean isValid(int[] pos, int force, int m) {
        int count = 1;
        int lastPos = pos[0];
        
        for (int i = 1; i < pos.length; ++i) {
            if (pos[i] - lastPos >= force) {
                if (++count >= m) return true;
                lastPos = pos[i];
            }
        }
        
        return false;
    }
}