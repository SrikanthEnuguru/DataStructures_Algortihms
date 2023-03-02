package practise.top.medium.backtracking;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells
 * are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * <p>
 * https://leetcode.com/problems/word-search/description/
 * https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/711/backtracking/4537/
 * https://leetcode.com/problems/word-search/editorial/
 */
public class WordSearch {
    int m;
    int n;
    String target;
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean[][] seen;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        target = word;
        seen = new boolean[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == target.charAt(0)) {
                    seen[row][col] = true;
                    if (backtrack(row, col, 1, board)) {
                        return true;
                    }
                    // this is backtracking condition
                    seen[row][col] = false;
                }
            }
        }

        return false;
    }

    public boolean backtrack(int row, int col, int i, char[][] board) {
        if (i == target.length()) {
            return true;
        }

        for (int[] direction : directions) {
            int nextRow = row + direction[0], nextCol = col + direction[1];
            if (valid(nextRow, nextCol) && !seen[nextRow][nextCol]) {
                if (board[nextRow][nextCol] == target.charAt(i)) {
                    seen[nextRow][nextCol] = true;
                    if (backtrack(nextRow, nextCol, i + 1, board)) {
                        return true;
                    }
                    // this is backtracking condition
                    seen[nextRow][nextCol] = false;
                }
            }
        }

        return false;
    }

    public boolean valid(int row, int col) {
        return 0 <= row && row < m && 0 <= col && col < n;
    }
}
