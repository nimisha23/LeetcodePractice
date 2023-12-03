class HitCounter {
    // TreeMap<Integer, Integer> map;
    // public HitCounter() {
    //     map = new TreeMap<>();
    // }
    
    // public void hit(int timestamp) {
    //     map.put(timestamp, map.getOrDefault(timestamp, 0) + 1);
    // }
    
    // public int getHits(int timestamp) {
    //     int count = 0;
    //     for(int i = Math.max(0, timestamp - 299); i <= timestamp; i++){
    //         count += map.getOrDefault(i, 0);
    //     }
    //     return count;
    // }
    // Queue<Integer> q;
    // public HitCounter() {
    //     q = new LinkedList<>();
    // }
    
    // public void hit(int timestamp) {
    //     q.add(timestamp);
    // }
    
    // public int getHits(int timestamp) {
    //     int diff = Math.max(0, timestamp-300);
    //     while(!q.isEmpty() && q.peek() <= diff) {
    //         q.remove();
    //     }
    //     return q.size();
    // }

    Deque<Pair<Integer, Integer>> dq;
    int total; //good thinking, keep a total var for keeping the count
    public HitCounter() {
        total = 0;
        dq = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        if(!dq.isEmpty() && dq.getLast().getKey() == timestamp) {
            int newCount = dq.getLast().getValue() + 1;
            dq.removeLast();
            dq.add(new Pair<Integer, Integer>(timestamp, newCount));
        } else {
            dq.add(new Pair<Integer, Integer>(timestamp, 1));
        }
        total++;
    }
    
    public int getHits(int timestamp) {
        int diff = Math.max(0, timestamp-300);
        while(!dq.isEmpty() && dq.getFirst().getKey() <= diff) {
            total -= dq.getFirst().getValue();
            dq.remove();
        }
        return total;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */