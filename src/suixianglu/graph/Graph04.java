package suixianglu.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class Graph04 {
    public static void main(String[] args) {
        System.out.println(new Solution01().numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}}));
        System.out.println(new Solution01().numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}}));
        System.out.println(new Solution02().numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}}));
        System.out.println(new Solution02().numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}}));

    }
}


/**
 * lc200. 岛屿数量
 * 深度优先搜索 回溯
 */
class Solution01 {

    int island = 1;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    // 如果是未遍历过的陆地 进行dfs
                    island++;
                    dfs(grid, i, j);
                }
            }
        }
        return island - 1;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            // 如果超出范围 直接返回
            return;
        }
        grid[i][j] = (char) ('0' + island);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
    }
}

/**
 * lc200. 岛屿数量
 * 广度优先搜索 队列解决
 */
class Solution02 {

    int island = 1;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    // 如果是未遍历过的陆地 进行bfs
                    island++;
                    bfs(grid, i, j);
                }
            }
        }
        return island - 1;
    }

    private void bfs(char[][] grid, int i, int j) {
        if (!isValid(grid, i, j)) {
            // 如果超出范围 直接返回
            return;
        }
        Deque<int[]> queue = new ArrayDeque<>();
        handle(grid, i, j, queue);

        while (!queue.isEmpty()) {
            int[] cur = queue.removeFirst();
            int curI = cur[0];
            int curJ = cur[1];
            // 上下左右遍历
            if (isValid(grid, curI + 1, curJ) && grid[curI + 1][curJ] == '1') {
                handle(grid, curI + 1, curJ, queue);
            }
            if (isValid(grid, curI - 1, curJ) && grid[curI - 1][curJ] == '1') {
                handle(grid, curI - 1, curJ, queue);
            }
            if (isValid(grid, curI, curJ + 1) && grid[curI][curJ + 1] == '1') {
                handle(grid, curI, curJ + 1, queue);
            }
            if (isValid(grid, curI, curJ - 1) && grid[curI][curJ - 1] == '1') {
                handle(grid, curI, curJ - 1, queue);
            }
        }


    }

    private boolean isValid(char[][] grid, int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }

    private void handle(char[][] grid, int i, int j, Deque<int[]> queue) {
        grid[i][j] = (char) ('0' + island);
        queue.offer(new int[]{i, j});
    }

}