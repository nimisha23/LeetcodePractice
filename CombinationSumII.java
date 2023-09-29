class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    public void helper(int[] candidates, int target, int index, List<Integer> list) {
        if(target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if(target < 0 || index == candidates.length) {
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            //pick
            if(i == index || candidates[i] != candidates[i-1]) {
                list.add(candidates[i]);
                helper(candidates, target-candidates[i], i+1, list);
                list.remove(list.size()-1);
            }
        }
    }
}