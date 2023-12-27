/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //TC : O(N)
    //SC : O(N)
    // HashMap<TreeNode, TreeNode> map;
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     map = new HashMap<>();
    //     createParentPtr(root, null, p, q);
    //     Set<TreeNode> ancestors = new HashSet<>();
    //     while(p != null) {
    //         ancestors.add(p);
    //         p = map.get(p);
    //     }
    //     while(!ancestors.contains(q)) {
    //         q = map.get(q);
    //     }
    //     return q;
    // }

    // public void createParentPtr(TreeNode root, TreeNode prev, TreeNode p, TreeNode q) {
    //     if(root == null) {
    //         return;
    //     }
    //     if(map.containsKey(p) && map.containsKey(q)) {
    //         return;
    //     }
    //     map.put(root, prev);
    //     prev = root;
    //     createParentPtr(root.left, prev, p, q);
    //     createParentPtr(root.right, prev, p, q);
    // }

    //     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    //     // Stack for tree traversal
    //     Deque<TreeNode> stack = new ArrayDeque<>();

    //     // HashMap for parent pointers
    //     Map<TreeNode, TreeNode> parent = new HashMap<>();

    //     parent.put(root, null);
    //     stack.push(root);

    //     // Iterate until we find both the nodes p and q
    //     while (!parent.containsKey(p) || !parent.containsKey(q)) {

    //         TreeNode node = stack.pop();

    //         // While traversing the tree, keep saving the parent pointers.
    //         if (node.left != null) {
    //             parent.put(node.left, node);
    //             stack.push(node.left);
    //         }
    //         if (node.right != null) {
    //             parent.put(node.right, node);
    //             stack.push(node.right);
    //         }
    //     }

    //     // Ancestors set() for node p.
    //     Set<TreeNode> ancestors = new HashSet<>();

    //     // Process all ancestors for node p using parent pointers.
    //     while (p != null) {
    //         ancestors.add(p);
    //         p = parent.get(p);
    //     }

    //     // The first ancestor of q which appears in
    //     // p's ancestor set() is their lowest common ancestor.
    //     while (!ancestors.contains(q))
    //         q = parent.get(q);
    //     return q;
    // }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    public TreeNode helper(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null || node == p || node == q) {
            return node;
        }
        TreeNode left = helper(node.left, p, q);
        TreeNode right = helper(node.right, p, q);
        if(left != null && right != null) {
            return node;
        } else if(left != null) {
            return left;
        } else{
            return right;
        }
    }
}