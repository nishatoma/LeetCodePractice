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
}
