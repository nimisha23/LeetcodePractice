class Solution {
    boolean[][] visited;
    int[][] dirs;
    int row;
    int col;
    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
        visited = new boolean[row][col];
        int count = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        visited[i][j] = true;
        for(int[] d : dirs) {
            int new_i = d[0] + i;
            int new_j = d[1] + j;
            if(new_i >= 0 && new_i < row && new_j >= 0 && new_j < col && grid[new_i][new_j] == '1' && !visited[new_i][new_j]) {
                dfs(grid, new_i, new_j);
            }
        }
    }
}