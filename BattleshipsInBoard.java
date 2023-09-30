class Solution {
    int r;
    int c;
    boolean[][] visited;
    int[][] dirs;
    int count;
    public int countBattleships(char[][] board) {
        r = board.length;
        c = board[0].length;
        visited = new boolean[r][c];
        dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        count = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(!visited[i][j] && board[i][j] == 'X') {
                    dfs(board, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] board, int i, int j) {
        visited[i][j] = true;

        if(board[i][j] == 'X') {
            for(int[] d : dirs) {
                int newRow = i + d[0];
                int newCol = j + d[1];
                if(newRow >= 0 && newRow < r && newCol >= 0 && newCol < c && !visited[newRow][newCol]) {
                    dfs(board, newRow, newCol);
                }
            }
        }
    }
}