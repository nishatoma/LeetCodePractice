package bitmanipulation;

public class ErrichtoBits {

    public static void main(String[] args) {

        printBinaryNumber(5);
    }

    // Print Number in binary?
    static void printBinaryNumber(int num) {

        for (int i = 30; i >= 0; i--) {
            if ((num & (1 << i)) != 0) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
        }
    }

}
