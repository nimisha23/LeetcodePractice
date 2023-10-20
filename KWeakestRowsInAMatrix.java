class Solution {
    //TC : O(M*N + MlogM)
    //Can be optimized
    // public int[] kWeakestRows(int[][] mat, int k) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     int row = mat.length;
    //     int col = mat[0].length;

    //     for(int i = 0; i < row; i++) {
    //         int count = 0;
    //         for(int j = 0; j < col; j++) {
    //             if(mat[i][j] == 1) {
    //                 count++;
    //             }
    //         }
    //         map.put(i, count);
    //     }

    //     PriorityQueue<Map.Entry<Integer, Integer>> pq = 
    //     new PriorityQueue<>((a,b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : a.getValue() - b.getValue());

    //     for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
    //         pq.offer(entry);
    //     }
    //     int[] result = new int[k];
    //     int i = 0;
    //     while(i < k) {
    //         Map.Entry<Integer, Integer> entry = pq.poll();
    //         result[i] = entry.getKey();
    //         i++;
    //     }
    //     return result;
    // }

    //Using Binary Search and PriorityQueue
    //TC : O(M*logN + M*log k) TC of binary search for all rows + priority queue
    //SC : O(M), we can do in O(k) space also, see approach 4, we don't keep a map just a PQ
    // public int[] kWeakestRows(int[][] mat, int k) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     //Max Heap of size k
    //     PriorityQueue<Map.Entry<Integer, Integer>> pq = 
    //     new PriorityQueue<>((a,b) -> a.getValue() == b.getValue() ? b.getKey() - a.getKey() : b.getValue() - a.getValue());

    //     int row = mat.length;
    //     int col = mat[0].length;
    //     for(int i = 0; i < row; i++) {
    //         int count = binarySearch(0, col-1, mat[i]);
    //         map.put(i, count);
    //     }
 
    //     for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
    //         pq.offer(entry);
    //         if(pq.size() > k) {
    //             pq.poll();
    //         }
    //     }
    //     int[] result = new int[k];
    //     while(k > 0) {
    //         Map.Entry<Integer, Integer> entry = pq.poll();
    //         result[k-1] = entry.getKey();
    //         k--;
    //     }
    //     return result;

    // }

    // public int binarySearch(int low, int high, int[] arr) {
    //     while(low <= high) {
    //         int mid = low + (high-low)/2;
    //         if(arr[mid] == 0) {
    //             //search left
    //             high = mid-1;
    //         } else {
    //             low = mid+1;
    //         }
    //     }
    //     return low;
    // }

     public int[] kWeakestRows(int[][] mat, int k) {

        int m = mat.length;
        int n = mat[0].length;

        int [] indexes = new int[k];
        int nextInsertIndex = 0;

        // This code does the same as the animation above.
        for (int c = 0; c < n && nextInsertIndex < k; c++) {
            for (int r = 0; r < m && nextInsertIndex < k; r++) {
                // If this is the first 0 in the current row.
                if (mat[r][c] == 0 && (c == 0 || mat[r][c - 1] == 1)) {
                    indexes[nextInsertIndex] = r;
                    nextInsertIndex++;
                }
            }
        }

        /* If there aren't enough, it's because some of the first k weakest rows
         * are entirely 1's. We need to include the ones with the lowest indexes
         * until we have at least k. */
        for (int r = 0; nextInsertIndex < k ; r++) {
            /* If index i in the last column is 1, this was a full row and therefore
             * couldn't have been included in the output yet. */
            if (mat[r][n - 1] == 1) {
                indexes[nextInsertIndex] = r;
                nextInsertIndex++;
            }
        }

        return indexes;

    }
        
        

}