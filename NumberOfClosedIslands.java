class Solution {
    int row;
    int col;
    int[][] dirs;
    boolean[][] visited;
    public int closedIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        visited = new boolean[row][col];
        int count = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 0 && !visited[i][j] && dfs(i, j, grid)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean dfs(int x, int y, int[][] grid) {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return false;
        }
        if (grid[x][y] == 1 || visited[x][y]) {
            return true;
        }
        visited[x][y] = true;
        boolean isClosed = true;
        for(int[] d : dirs) {
            int new_x = x + d[0];
            int new_y = y + d[1];
            if (!dfs(new_x, new_y, grid)) {
                isClosed = false;
            }
        }
        return isClosed;
    }
}