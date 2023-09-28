class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    public void helper(int[] candidates, int target, int index, List<Integer> list) {
        if(index == candidates.length || target < 0) {
            return;
        }
        if(target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        //pick
        list.add(candidates[index]);
        helper(candidates, target - candidates[index], index, list);

        //not pick
        list.remove(list.size()-1);
        helper(candidates, target, index+1, list);
    }
}