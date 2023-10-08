class Solution {
    int row;
    int col;
    int[][] dirs;
    boolean[][] visited;
    int count=0;
    public int numEnclaves(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};
        visited = new boolean[row][col];

        //first and last column
        for(int i = 0; i < row; i++) {
            if(grid[i][0] == 1 && !visited[i][0]) {
                    dfs(i, 0, grid);
            }
            if(grid[i][col-1] == 1 && !visited[i][col-1]) {
                    dfs(i, col-1, grid);
            }        
        }

        //first and last row
        for(int i = 0; i < col; i++) {
            if(grid[0][i] == 1 && !visited[0][i]) {
                    dfs(0, i, grid);
            }   
            if(grid[row-1][i] == 1 && !visited[row-1][i]) {
                    dfs(row-1, i, grid);
            }     
        }

        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j, int[][] grid) {
        visited[i][j] = true;
        for(int[] d : dirs) {
            int new_i = d[0] + i;
            int new_j = d[1] + j;
            if(new_i >= 0 && new_i < row && new_j >=0 && new_j < col && 
            !visited[new_i][new_j] && grid[new_i][new_j] == 1) {
                dfs(new_i, new_j, grid);
            }
        }

    }
}