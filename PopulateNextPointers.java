/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
    //     if(root == null || root.left == null || root.right == null) {
    //         return root;
    //     }
    //     Node prev = root;
    //     while(prev.left != null) {
    //         Node tmp = prev;
    //         while(prev != null) {
    //             prev.left.next = prev.right;
    //             if (prev.next != null)
    //                 prev.right.next = prev.next.left;
    //             prev = prev.next;
    //         }
    //         prev = tmp.left;
    //     }
    //    return root;

        if(root == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                Node prev = q.poll();
                if(size > 1) //this is because 3 will start pointing to 4, so for each level the last element next ptr shouldn't point to q.peek() 
                    prev.next = q.peek(); //if queue is empty, q.peek() returns null and doesn't throw NPE
                size--;
                if(null != prev.left) 
                    q.add(prev.left);
                if(null != prev.right)
                    q.add(prev.right);
            }
        }
        return root;
    }
}