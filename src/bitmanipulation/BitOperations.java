package bitmanipulation;

public class BitOperations {

    public static void main(String[] args) {
        System.out.println(isEven(0));
        System.out.println(isEven(1));
        System.out.println(isEven(2));
        System.out.println(isEven(3));
        System.out.println(isEven(4));
        System.out.println(isEven(5));
        System.out.println(isEven(360000000));
        System.out.println(isEven(Integer.MIN_VALUE));
        System.out.println(toBinarySigned(-8));
        System.out.println("Get 3rd bit of: " + toBinarySigned(503));
        System.out.println("3rd bit of: " + toBinarySigned(503) + " = " + getIthBit(503, 3));
        System.out.println("Get first bit of: " + toBinarySigned(503854));
        System.out.println("first bit of: " + toBinarySigned(503854) + " = " + getIthBit(503854, 50));
        System.out.println("My binary number before setting 3rd bit: " + toBinarySigned(8));
        System.out.println("My binary number after setting 3rd bit: " + toBinarySigned(setTheIthBit(8, 3)));
        System.out.println("My binary number before resetting 3rd bit: " + toBinarySigned(15));

        System.out.println("My binary number after resetting 3rd bit: " + toBinarySigned(resetIthBit(15, 3)));
        int x = 656;
        System.out.println("Get right most bit of " + toBinarySigned(x));
        System.out.println("Answer " + getRightMostBit(x));
        System.out.println(x);
        System.out.println(getNthMagicNumber(1));
        System.out.println(getNthMagicNumber(2));
        System.out.println(getNthMagicNumber(3));
        System.out.println(getNthMagicNumber(4));
        System.out.println(getNthMagicNumber(5));
        System.out.println(getNthMagicNumber(6));
        System.out.println(getNthMagicNumber(7));
        System.out.println(getNthMagicNumber(8));
        System.out.println(getNumDigits(10, 16));

        System.out.println(isPowerOfTwoV1(40));
        System.out.println(isPowerOfTwoV1(32));
        System.out.println(isPowerOfTwoV1(64));
        System.out.println(isPowerOfTwoV1(100));
        System.out.println(isPowerOfTwoV1(1));
        System.out.println(isPowerOfTwoV1(64));
        System.out.println(isPowerOfTwoV1(2));
        System.out.println(isPowerOfTwoV1(8));
    }

    static boolean isEven(int n) {
        return (n & 1) == 0;
    }

    static String toBinarySigned(int n) {
        StringBuilder sb = new StringBuilder();
        int x = Math.abs(n);
        while (Math.abs(x) >= 1) {
            sb.insert(0, Math.abs(x) % 2);
            x /= 2;
        }
        if (n < 0){
            sb.insert(0, "1b");
        } else {
            sb.insert(0, "0b");
        }
        return sb.toString();
    }

    static int binaryToDecimal(String b) {
        int sum = 0;

        for (int i = b.length() - 1; i >= 0; i--) {
            sum += Character.getNumericValue(b.charAt(i)) * Math.pow(2, (b.length() - 1) - i);
        }

        return sum;
    }

    static int getIthBit(int n, int i) {
        return ((n >> (i - 1)) & 1);
    }

    static int setTheIthBit(int n, int i) {
        return (n | (1 << (i - 1)));
    }

    static int resetIthBit(int n, int i) {
        return (n & (~(1 << (i - 1))));
    }

    static int getRightMostBit(int n) {
        int count = 1;
        while ((n & 1) != 1) {
            n >>= 1;
            count++;
        }
        return count;
    }

    static int getNthMagicNumber(int n ) {
        int x = n;
        int sum = 0;
        int count = 1;
        while (x > 0) {
            sum += (x & 1) * Math.pow(5, count);
            x >>= 1;
            count++;
        }

        return sum;
    }

    static int getNumDigits(int n, int b) {
        int lognBaseB = (int) (Math.log(n) / Math.log(b));

        return lognBaseB + 1;
    }

    static int getPascalSumForNthRow(int n) {
        return (1 << (n - 1));
    }

    static boolean isPowerOfTwoV1(int n) {

        return (n != 0) && ((n & (n - 1)) == 0);
    }
}
