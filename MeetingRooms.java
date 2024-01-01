class Solution {
    //TC : O(n log n) -> due to sorting
    //SC : O(1)
    public boolean canAttendMeetings(int[][] intervals) {
        //basically find if there are any overlapping intervals, if there is that means person cannot attend meetings
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);

        for(int i = 0; i < intervals.length-1; i++) {
            if(intervals[i+1][0] < intervals[i][1]) {
                return false;
            }
        }
        return true;
    }
}