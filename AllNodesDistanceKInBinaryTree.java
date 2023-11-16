/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //Logic - create parent pointers for each node, store in hashmap and then do dfs for the target node
 //TC : O(N)
 //SC : O(N)
 class Solution {
    // HashMap<TreeNode, TreeNode> map;
    // List<Integer> result;
    // HashSet<TreeNode> visited;
    // public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    //    map = new HashMap<>();
    //    result = new ArrayList<>();
    //    visited = new HashSet<>();
    //    helper(root, null);

    //    traverseTree(target, 0, k);
    //    return result;
    // }

    // public void helper(TreeNode root, TreeNode prev) {
    //     if(root == null) return;

    //     map.put(root, prev);
    //     prev = root;
    //     helper(root.left, prev);
    //     helper(root.right, prev);
    // }

    // public void traverseTree(TreeNode root, int distance, int k) {
    //     if(root == null || visited.contains(root)) return;
    //     visited.add(root);

    //     if(distance == k) {
    //         result.add(root.val);
    //         return;
    //     }
    //     traverseTree(root.left, distance+1, k);
    //     traverseTree(root.right, distance+1, k);
    //     traverseTree(map.get(root), distance+1, k);
    // }

    Map<Integer, List<Integer>> map;
    HashSet<Integer> visited;
    List<Integer> result;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        map = new HashMap<>();
        visited = new HashSet<>();
        result = new ArrayList<>();

        preOrderTraversal(root, null);
        dfs(target.val, 0, k);
        return result;
    }

    public void preOrderTraversal(TreeNode node, TreeNode prev) {
        if (node != null && prev != null) {
            map.computeIfAbsent(node.val, k -> new ArrayList<>()).add(prev.val);
            map.computeIfAbsent(prev.val, k -> new ArrayList<>()).add(node.val);
        }
        if (node.left != null) {
            preOrderTraversal(node.left, node);
        }
        if (node.right != null) {
            preOrderTraversal(node.right, node);
        }
    }

    public void dfs(int curr, int distance, int k) {
        if (distance == k) {
            result.add(curr);
            return;
        }
        visited.add(curr);
        for(int neighbor : map.getOrDefault(curr, new ArrayList<>())) {
            if(!visited.contains(neighbor)) {
                dfs(neighbor, distance+1, k);
            }
        }
    }
}

