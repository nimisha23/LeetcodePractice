class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        int result = Integer.MAX_VALUE;
        for(int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        while(low <= high) {
            int mid = low + (high-low)/2;
            if(isPossible(mid, weights, days)) {
                result = Math.min(result, mid);
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return result;
    }

    public boolean isPossible(int capacity, int[] weights, int days) {
        int c = 0;
        int day = 1;
        for(int w : weights) {
            c += w;
            if(c > capacity) {
                day++;
                c = w;
            }
        }
        return day <= days;
    }
}