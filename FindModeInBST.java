class Solution {
    //TC : O(N)
    //SC : O(N) -> due to recursion stack space but we don't need to keep a data structure to store freq of elements
    int currNum;
    int currMax;
    int max;
    List<Integer> res;
    public int[] findMode(TreeNode root) {
        currNum = -1;
        currMax = -1;
        res = new ArrayList<>();
        max = Integer.MIN_VALUE;
        inorderTraversal(root);
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        
        return result;
    }

    void inorderTraversal(TreeNode root) {
        if(root == null) return;
        inorderTraversal(root.left);
        if(root.val == currNum) {
            currMax++;
        } else {
            currNum = root.val;
            currMax = 1;
        }
        if(currMax > max) {
            res = new ArrayList(); //note we are initializing the res list everytime because our max will change everytime so we will discard the prev results so that in the end we will have the max values, for example, first any value with freq 1 will be greater than max but if we later get an element with freq 5 we want to discard the earlier one
            max = currMax;
        }   
        if(currMax == max) {
            res.add(root.val);
        }
        inorderTraversal(root.right);

    }

    // Map<Integer, Integer> map;
    // public int[] findMode(TreeNode root) {
    //     map = new HashMap<>();
    //     List<Integer> res = new ArrayList<>();
    //     inorderTraversal(root);
    //     int maxValue = 0;
    //     for (int key : map.keySet()) {
    //         maxValue = Math.max(maxValue, map.get(key));
    //     }
    //     for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
    //         if(maxValue == entry.getValue()) {
    //             res.add(entry.getKey());
    //         }
    //     }
    //     int[] result = new int[res.size()];
    //     for (int i = 0; i < res.size(); i++) {
    //         result[i] = res.get(i);
    //     }
        
    //     return result;
    // }

    // void inorderTraversal(TreeNode root) {
    //     if(root == null) return;
    //     inorderTraversal(root.left);
    //     map.put(root.val, map.getOrDefault(root.val, 0) + 1);
    //     inorderTraversal(root.right);

    // }
}