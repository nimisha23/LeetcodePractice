class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> 
            (a[0]-b[0])
        );
        // int i = 0;
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        // while(i < intervals.length-1) {
        //     int[] curr = intervals[i];
        //     while(i < intervals.length-1 && intervals[i+1][0] <= curr[1]) { //overlapping interval
        //         curr[0] = Math.min(curr[0], intervals[i+1][0]);
        //         curr[1] = Math.max(curr[1], intervals[i+1][1]);
        //         i++;
        //     }
        //     res.add(curr);
        //     i++;
        // }
        // if(i == n-1) {
        //     res.add(intervals[n-1]);
        // }
        // return res.toArray(new int[res.size()][2]);

        //difference between the above and below approach is in the first one we are not comparing two every time, we have a while loop which will go on till overlapping intervals are there, but in second approach we are comparing prev and curr ones
        res.add(intervals[0]);
        for(int i = 1; i < n; i++) {
            int l = res.size();
            if(res.get(l-1)[1] >= intervals[i][0]) {
                res.set(l-1, new int[]{Math.min(res.get(l-1)[0], intervals[i][0]), Math.max(res.get(l-1)[1], intervals[i][1])});
            } else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}