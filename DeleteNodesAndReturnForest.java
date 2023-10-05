class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) set.add(i);
        List<TreeNode> res = new ArrayList<>();
        dfs(root, set, res, true);
        return res;
    }

    private TreeNode dfs(TreeNode node, Set<Integer> set, List<TreeNode> res, boolean isRoot) {
        if (node == null) {
            return null;
        }
        boolean deleted = set.contains(node.val);
        if(isRoot && !deleted) {
            res.add(node);
        }
        node.left = dfs(node.left, set, res, deleted);
        node.right = dfs(node.right, set, res, deleted);
        return deleted ? null : node;
    }
}