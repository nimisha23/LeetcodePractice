class Solution {
    //Using rowStart, rowEnd was giving Stack overflow error, not sure why
    //TC : O(log N * N2) -> after log N iteration times the length of grid will be 1, and in each iteration we are checking if cell values are different
    //SC : O(log N), the leftmost recursion will go on till grid size is 1, so log N times
    public Node construct(int[][] grid) {
        return constructQuadTree(grid, 0, 0, grid.length);
    }

    public Node constructQuadTree(int[][] grid, int row, int col, int length) {
        if(isAllValueSame(grid, row, col, length)) {
            return new Node(grid[row][col] == 1, true);
        } else {
            Node root = new Node(true, false);
            //recurse
            root.topLeft = constructQuadTree(grid, row, col, length/2);
            root.topRight = constructQuadTree(grid, row, col+length/2, length/2);
            root.bottomLeft = constructQuadTree(grid, row+length/2, col, length/2);
            root.bottomRight = constructQuadTree(grid, row+length/2, col+length/2, length/2);
            return root;
        }
    }

    public boolean isAllValueSame(int[][] grid, int row, int col, int length) {
        for(int i = row; i < row+length; i++) {
            for(int j = col; j < col+length; j++) {
                if(grid[i][j] != grid[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}