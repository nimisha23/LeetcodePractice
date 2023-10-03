class Solution {
    int row;
    int col;
    int[][] dirs;
    boolean[][] visited;
    int count;
    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        visited = new boolean[row][col];
        int result = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                count = 0;
                if(!visited[i][j] && grid[i][j] == 1) {
                    count++;
                    dfs(i, j, grid);
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }

    public void dfs(int i, int j, int[][] grid) {
        visited[i][j] = true;
        
        for(int[] d : dirs) {
            int new_i = d[0] + i;
            int new_j = d[1] + j;
            if(new_i >= 0 && new_i < row && new_j >= 0 && new_j < col && !visited[new_i][new_j] && grid[new_i][new_j] == 1) {
                count++;
                dfs(new_i, new_j, grid);
            }
        }
    }
}