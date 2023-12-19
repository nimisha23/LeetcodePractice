class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> list = new ArrayList<>();
        int[] indegree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        int semesterCount = 0;

        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for(int[] r : relations) {
            list.get(r[0]-1).add(r[1]-1);
            indegree[r[1]-1]++;
        }
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                int node = q.poll();
                for(int neighbor : list.get(node)) {
                    indegree[neighbor]--;
                    if(indegree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
                size--;
            }
            semesterCount++;
        }
        for(int i = 0; i < n; i++) {
            if(indegree[i] != 0) {
                return -1;
            }
        }
        return semesterCount;
    }
}