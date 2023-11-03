class StockSpanner {
    //Use monotonic stack, they have the property that the stack is decreasing or increasing, here we're using a decreasing monotonic stack
    //in order to have a dec M.S. when we are inserting a new ele, if we find ele at top less than the curr element we pop and we stop when the ele at top is greater, this way we'll have a dec m.s.
    //TC : amortised O(1) : refer to expl in solution
    //SC : O(n)
    Stack<int[]> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int count = 1;
        while(!st.isEmpty() && st.peek()[0] <= price) {
            count += st.pop()[1];
        }
        st.push(new int[]{price, count});
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */