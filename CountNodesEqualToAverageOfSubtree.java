/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result = 0;
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return result;
    }

    public Pair<Integer,Integer> helper(TreeNode root) {
        if(root == null) {
            return null;
        }

        Pair<Integer,Integer> left = helper(root.left);
        Pair<Integer,Integer> right = helper(root.right);
        int sum = root.val;
        int count = 1;
        if(null != left) {
            sum += left.getValue();
            count += left.getKey();
        }
        if(null != right) {
            sum += right.getValue();
            count += right.getKey();
        }
        if(sum/count == root.val) {
            result++;
        }
        return new Pair<>(count, sum);
    }
}