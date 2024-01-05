class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowGridValues;
        Set<Character> colGridValues;
        Set<Character> boxGridValues;
        for(int i = 0; i < board.length; i++) {
            rowGridValues = new HashSet<>();
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] != '.' && !rowGridValues.add(board[i][j])) {
                    return false;
                }
            }

            colGridValues = new HashSet<>();
            for(int j = 0; j < board.length; j++) {
                if(board[j][i] != '.' && !colGridValues.add(board[j][i])) {
                    return false;
                }
            }

            boxGridValues = new HashSet<>();
            for(int j = 0; j < board.length; j++) {
                int row_index = 3 * (i/3);
                int col_index = 3 * (i%3);
                if(board[row_index + j/3][col_index + j%3] != '.' && !boxGridValues.add(board[row_index + j/3][col_index + j%3])) {
                    return false;
                }
            }    
        }
        return true;
    }
}