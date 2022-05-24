package recursion;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2 ,3 ,4 ,5};

        System.out.println(cntZero(30203));
    }

    private static boolean isPal(int n) {
        return n == rev(n);
    }

    private static int rev(int n) {
        if (n <= 0) return 0;

        double len = Math.floor(Math.log10(n));
        int mul = (int) Math.pow(10.0, len);
        int rem = n % 10;
        return rem * mul + rev(n / 10);
    }

    private static void passingNum(int n) {
        if (n == 0) return;

        System.out.println(n);
        passingNum(--n);
    }

    private static int cntZero(int n) {
        if (n == 0) {
            return 0;
        }

        return ((n % 10) == 0 ? (1 + cntZero(n / 10)) : (cntZero(n / 10)));
    }

    private static int sumDigit(int n) {
        if (n == 0) return 0;

        int rem = n % 10;

        return rem + sumDigit(n / 10);
    }

    private static int prodDigits(int n) {
        if (n == 1) return 1;

        return (n % 10) * prodDigits(n / 10);
    }

    private static int sum(int n) {
        if (n == 0) return 0;

        return n + sum(n - 1);
    }

    static int fact(int n) {
        if (n == 1) return 1;

        return n * fact(n - 1);
    }

    private static void pr(int n) {
        if (n == 0) return;

        pr(n - 1);
        System.out.print (n + " ");
    }

    private static int fib(int n) {
        if (n < 2) return n;

        return fib(n - 1) + fib(n - 2);
    }

    private static int bs(int[] arr, int lo, int hi, int target) {
        if (lo < hi) {
            int mid = lo + (hi - lo ) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                // look left
                return bs(arr, lo, mid, target);
            } else {
                return bs(arr, mid + 1, hi, target);
            }

        }

        return -1;
    }

}
