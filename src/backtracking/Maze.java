package backtracking;

public class Maze {

    public static void main(String[] args) {

        System.out.println(count(0, 2, 2, 2));

    }

    static int count(int startR, int startC, int endR, int endC) {

        if (startC == endC || startR == endR) {
            return 1;
        }
        
        int right = count(startR, startC + 1, endR, endC);
        int down = count(startR + 1, startC, endR, endC);

        return right + down;
    }
}
