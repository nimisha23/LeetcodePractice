class Solution {
    //TC : O(N)
    //SC : O(N)
    // public String minRemoveToMakeValid(String s) {
    //     Set<Integer> indexToRemove = new HashSet<>();
    //     Stack<Integer> st = new Stack<>();
    //     StringBuilder sb = new StringBuilder();
    //     for(int i = 0; i < s.length(); i++) {
    //         char ch = s.charAt(i);
    //         if(ch == '(') {
    //             st.push(i);
    //         } else if(ch == ')') {
    //             if(!st.isEmpty()) {
    //                 st.pop();
    //             } else {
    //                 indexToRemove.add(i);
    //             }
    //         } 
    //     }
    //     while(!st.isEmpty()) {
    //         indexToRemove.add(st.pop());
    //     }
    //     for(int i = 0; i < s.length(); i++) {
    //         if(!indexToRemove.contains(i)) {
    //             sb.append(s.charAt(i));
    //         }
    //     }
    //     return sb.toString();
    // }

    //i know using just balance/stack, we can take care of closed ones but not open ones, so in the end we might end with string like
    // lee(t(c)o)de(( -> now to fix this, we will reverse the string and make open as closed brackets and closed as open. (because we have limit on closed based on size of open)
    public String minRemoveToMakeValid(String s) { 
        StringBuilder result = helper(new StringBuilder(s), '(', ')');
        result = helper(result.reverse(), ')', '(');
        return result.reverse().toString();
    }
 
    public StringBuilder helper(StringBuilder s, char open, char close) { //we return StringBuilder becauuse string in java doesn't have reverse func
        int balance = 0; //take it similar to stack size
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == open) {
                balance++;
                sb.append(ch);
            } else if(ch == close) {
                if(balance != 0) {
                    balance--;
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }
        }
        return sb;
    }
}