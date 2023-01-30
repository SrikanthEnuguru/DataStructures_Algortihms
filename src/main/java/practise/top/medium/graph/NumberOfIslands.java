package practise.top.medium.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * https://leetcode.com/problems/number-of-islands/
 * <p>
 * https://leetcode.com/problems/number-of-islands/solutions/127691/number-of-islands/
 */
public class NumberOfIslands {
    int m;
    int n;
    Set<String> seen = new HashSet<>();
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * Time complexity : O(M×N) where M is the number of rows and N is the number of columns.
     * <p>
     * Space complexity : worst case O(M×N) in case that the grid map is filled with lands where DFS goes by M×N deep.
     */
    public int numIslands_ChangeGrid(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfs_ChangeGrid(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2'; // change value to value other than 1

        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);

    }

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                String hash = r + "," + c;
                if (grid[r][c] == '1' && !seen.contains(hash)) {
                    ans++;
                    seen.add(hash);
                    dfs(grid, r, c);
                }
            }

        }
        return ans;
    }

    public void dfs(char[][] grid, int r, int c) {
        for (int[] direction : directions) {
            int nextRow = r + direction[0];
            int nextCol = c + direction[1];
            String hash = nextRow + "," + nextCol;
            if (!seen.contains(hash) && isValid(grid, nextRow, nextCol)) {
                seen.add(hash);
                dfs(grid, nextRow, nextCol);
            }
        }
    }

    public boolean isValid(char[][] grid, int r, int c) {
        return 0 <= r && r < m && 0 <= c && c < n && grid[r][c] == '1';
    }
}
