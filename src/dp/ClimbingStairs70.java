package dp;

class ClimbingStairs70 {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairs(n));
        n = 10;
        System.out.println(climbStairs(n));
        n = 45;
        System.out.println(climbStairs(n));
    }

    /**
     *
     * @param n number of stairs
     * @return the number of way we can climb n amount of stairs stairs
     */
    public static int climbStairs(int n) {

        if (n <= 1) {
            return 1;
        }

        int prevPrev = 1;
        int prev = 1;
        int result = 0;

        for (int i = 2; i <= n; i++) {
            result = prevPrev + prev;
            prevPrev = prev;
            prev = result;
        }

        return result;
    }
}