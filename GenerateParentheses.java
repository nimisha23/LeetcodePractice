class Solution {
    //TC : Exponential : (2^2N * N) -> we have a string of length 2n and we need to find possible valid combinations, so for each index we take or not take, so 2^2N, we also need to divide by a number because we are not calc all possible combinations, we have check of open < max and close < open, then we need O(N) TC to copy string to result
    //SC : O(N) -> max height of recursive stack can be 2*N so SC = O(N)
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(0, 0, n, sb, result);
        return result;
    }

    public void helper(int open, int close, int max, StringBuilder sb, List<String> result) {
        if(sb.length() == 2*max) {
            result.add(sb.toString());
        }
        if(open < max) {
            sb.append("(");
            helper(open+1, close, max, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open) {
            sb.append(")");
            helper(open, close+1, max, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}