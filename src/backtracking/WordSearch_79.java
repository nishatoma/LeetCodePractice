package backtracking;

class WordSearch_79 {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (wordExists(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean wordExists(int row, int col, char[][] board, String word, int count) {

        if (count == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }

        if (word.charAt(count) != board[row][col]) {
            return false;
        }

        board[row][col] ^= 256;

        boolean visited = wordExists(row + 1, col, board, word, count + 1)
                || wordExists(row - 1, col, board, word, count + 1)
                || wordExists(row, col - 1, board, word, count + 1)
                || wordExists(row, col + 1, board, word, count + 1);

        board[row][col] ^= 256;

        return visited;
    }
}