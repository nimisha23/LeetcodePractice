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
    // HashMap<TreeNode, TreeNode> map;
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     map = new HashMap<>();
    //     createParentPtr(root, null, p, q);
    //     if(!map.containsKey(p) || !map.containsKey(q)) {
    //         return null;
    //     }
    //     Set<TreeNode> ancestors = new HashSet<>();
    //     while(p != null) { //because parent of root is null
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = helper(root, p, q);
        if(ans == p) {
            if(dfs(p, q)) {
                return p;
            } else {
                return null;
            }
        } else if(ans == q) {
            if(dfs(q, p)) {
                return q;
            } else {
                return null;
            }
        }
        return ans;
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

    public boolean dfs(TreeNode source, TreeNode target) {
        if(source == null) {
            return false;
        } 
        if(source == target) {
            return true;
        }
        return dfs(source.left, target) || dfs(source.right, target);
    }

}