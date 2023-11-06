class BrowserHistory {
    DLLNode root;
    DLLNode temp;
    public BrowserHistory(String homepage) {
        root = new DLLNode(homepage);
        temp = root;
    }
    
    public void visit(String url) {
        DLLNode node = new DLLNode(url);
        temp.next = node;
        node.prev = temp;
        temp = temp.next;
    }
    
    public String back(int steps) {
        int count = 0;
        while(temp.prev != null) {
            temp = temp.prev;
            count++;
            if(count == steps) {
                return temp.url;
            }
        }
        return temp.url;
    }
    
    public String forward(int steps) {
        int count = 0;
        while(temp.next != null) {
            temp = temp.next;
            count++;
            if(count == steps) {
                return temp.url;
            }
        }
        return temp.url;
    }
}

class DLLNode {
    public String url;
    public DLLNode prev, next;

    DLLNode(String url) {
        this.url = url;
        this.prev = null;
        this.next = null;
    }
};

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */