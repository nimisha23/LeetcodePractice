class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[0]-b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1]-b[1]));

        pq.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= pq.peek()[1]) { //if new meeting start time is greater than the earliest end time then we can use the same meeting room
                pq.remove();
                pq.add(intervals[i]);
            } else { //we need a new meeting room, don't remve from pq and add this meeting as well
                pq.add(intervals[i]);           
            }
        }
        return pq.size();
    }
}