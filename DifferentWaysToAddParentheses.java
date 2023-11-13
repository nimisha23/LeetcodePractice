class Solution {
    // V V Good solution, see first solution by 2guotou and video to understand better
    //Use map to store computation of expression, for example 2*3 will be calc twice
    Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        if(map.containsKey(expression)) return map.get(expression);
        int n = expression.length();
        List<Integer> res = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            char ch = expression.charAt(i);
            if(ch == '+' || ch == '*' || ch == '-') {
                String part1 = expression.substring(0, i);
                String part2 = expression.substring(i+1);
                List<Integer> res1 = diffWaysToCompute(part1);
                List<Integer> res2 = diffWaysToCompute(part2);
                //We are not doing res.get(0) because we will get list of results and we need to calc for all, for example, 2*(3-(4*5)) and 2*((3-4)*5)
                for (Integer x :   res1) {
                    for (Integer y :   res2) {
                        int result = 0;
                        switch(ch) {
                            case '+': 
                            result = x+y;
                            break;
                            case '-': 
                            result = x-y;
                            break;
                            case '*': 
                            result = x*y;
                            break;
                        }
                        res.add(result);
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(expression));
        }
        //we are not checking if exp.length() == 1 at the beginning because single value can be 11 also in which case length will be 2
        map.put(expression, res);
        return res;
    }
}