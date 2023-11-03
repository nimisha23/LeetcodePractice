class Solution {
    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        //convert matrix to adj list
        int n = isConnected.length;
        int count = 0;
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, isConnected);
                count++;
            }
        }
        return count;
    }

    public void dfs(int node, int[][] isConnected) {
        visited[node] = true;
        for(int i = 0; i < isConnected[node].length; i++) {
            if(!visited[i] && i != node && isConnected[node][i] == 1) {
                dfs(i, isConnected);
            }
        }
    }
}