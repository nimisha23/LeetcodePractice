class Solution {
    int[] root;
    int[] rank;
    int count;
    public int earliestAcq(int[][] logs, int n) {
        root = new int[n];
        rank = new int[n];
        count = n;

        Arrays.sort(logs, (a, b) -> a[0]-b[0]);

        for(int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }

        for(int[] log : logs) {
            int x = log[1];
            int y = log[2];
            union(x, y);
            if(count == 1) {
                return log[0];
            }
        }
        return -1;
    }

    public void union(int x, int y) {
        int r1 = find(x);
        int r2 = find(y);
        if(r1 == r2) {
            return;
        } else {
            if(rank[r1] > rank[r2]) {
                root[r2] = r1;
            } else if (rank[r2] > rank[r1]) {
                root[r1] = r2;
            } else {
                root[r2] = r1;
                rank[r1] += 1;
            }
            count--;
            System.out.println(count);
        }
    }

    public int find(int x) {
        if(root[x] == x) {
            return x;
        }
        return root[x] = find(root[x]);
    }
}

