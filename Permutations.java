class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        int len = nums.length;
        boolean[] visited = new boolean[len];
        helper(nums, 0, visited, new ArrayList<>());
        return result;
    }

    public void helper(int[] nums, int index, boolean[] visited, List<Integer> permutation) {
        if(permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for(int i = index; i < nums.length; i++) {
            //pick
            if(!visited[i]) {
                permutation.add(nums[i]);
                visited[i] = true;
                helper(nums, 0, visited, permutation);
            } else {
                continue;
            }
            //backtrack
            permutation.remove(permutation.size()-1);
            visited[i] = false;
        }
    }
}