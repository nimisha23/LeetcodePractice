/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> ancestor = new HashSet<>();
        while(p != null) {
            ancestor.add(p);
            p = p.parent;
        }
        while(!ancestor.contains(q)) {
            q = q.parent;
        }
        return q;
    }
}