package dfs;

public class BattleShipsInABoard_419 {

    public int countBattleships(char[][] board) {
        if (board == null) {
            throw new IllegalArgumentException("Input is null");
        }
        if (board.length == 0 || board[0].length == 0) {
            return 0;
        }

        int count = 0;
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (board[i][j] == 'X' && (i == rows - 1 || board[i + 1][j] == '.') && (j == cols - 1 || board[i][j + 1] == '.')) {
                    count++;
                }
            }
        }

        return count;
    }
}
