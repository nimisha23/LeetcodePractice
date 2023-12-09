class Solution {
    //TC : O(m. nlog n) where m is the no of rows and n is the no of columns
    //SC : O(m.n)
      // public int largestSubmatrix(int[][] matrix) {
      //     int row = matrix.length;
      //     int col = matrix[0].length;
      //     int max = Integer.MIN_VALUE;
  
      //     for(int i = 0; i < row; i++) {
      //         for(int j = 0; j < col; j++) {
      //             if(matrix[i][j] != 0 && i > 0) { //i > 0 because for first row we already know the values
      //                 matrix[i][j] += matrix[i-1][j];
      //             }
      //         }
      //             int[] curr = matrix[i].clone(); //imp, otherwise sorting curr will sort matrix[i] as well because ref of matrix is passed in curr
      //             Arrays.sort(curr); //ascending order sort
  
      //             int base = 1;
      //             for(int k = col-1; k >= 0; k--) {
      //                 max = Math.max(max, base * curr[k]);
      //                 base++;
      //             }
      //         }
      //     return max;
      // }
    //TC : O(m. nlog n) where m is the no of rows and n is the no of columns
    //SC : O(n)
      //     public int largestSubmatrix(int[][] matrix) {
      //     int row = matrix.length;
      //     int col = matrix[0].length;
      //     int max = Integer.MIN_VALUE;
      //     int curr[] = new int[col];
      //     int prev[] = new int[col];
  
      //     for(int i = 0; i < row; i++) {
      //       curr = matrix[i].clone(); //if we don't use clone we are again modifying the matrix because references will be the same
      //         for(int j = 0; j < col; j++) {
      //             if(curr[j] != 0) { //we have prev here so no need for the i > 0 check
      //                 curr[j] += prev[j];
      //             }
      //         }
      //         int[] sortedRow = curr.clone(); // we have to clone else prev will refer to sorted row values which is incorrect
      //         Arrays.sort(sortedRow); //ascending order sort
  
      //             int base = 1;
      //             for(int k = col-1; k >= 0; k--) {
      //                 max = Math.max(max, base * sortedRow[k]);
      //                 base++;
      //             }
      //             prev = curr;
      //         }
      //     return max;
      // }
  
        //TC : O(m.n) where m is the no of rows and n is the no of columns
    //SC : O(n)
          public int largestSubmatrix(int[][] matrix) {
          int row = matrix.length;
          int col = matrix[0].length;
          int max = 0;
          List<Pair<Integer, Integer>> prev = new ArrayList<>();
          List<Pair<Integer, Integer>> curr;
          boolean[] seen;
  
          for(int i = 0; i < row; i++) {
             seen = new boolean[col];
             curr = new ArrayList<>();
                  for(Pair<Integer, Integer> p : prev) {
                    int height = p.getKey();
                    int colNo = p.getValue();
                    if(matrix[i][colNo] == 1) {
                      curr.add(new Pair<>(height+1, colNo));
                      seen[colNo] = true;
                    }
                  }
                  for(int j = 0; j < col; j++) {
                    if(!seen[j] && matrix[i][j] == 1) {
                      curr.add(new Pair<>(1, j));
                    }
                  }
                  int base = 1;
                  for(Pair<Integer, Integer> p : curr) {
                    max = Math.max(max, base * p.getKey());
                    base++;
                  }
                  prev = curr;
              }
          return max;
      }
  }