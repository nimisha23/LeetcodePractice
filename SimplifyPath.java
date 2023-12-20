class Solution {
    public String simplifyPath(String path) {
        // StringBuilder sb = new StringBuilder();
        // Stack<String> st = new Stack<>();
        // String[] arr = path.split("/");
        // for(String a : arr) {
        //     if(a.isEmpty() || a.equals("/") || a.equals(".")) {
        //         continue;
        //     } else if(a.equals("..")) {
        //         if(!st.isEmpty()) {
        //             st.pop();
        //         }
        //     } else {
        //         st.push(a);
        //     }
        // }
        
        // for(String ele : st) {
        //     sb.append("/");
        //     sb.append(ele);
        // }
        // return sb.length() == 0 ? "/" : sb.toString();

        StringBuilder sb = new StringBuilder();
        ArrayDeque<String> st = new ArrayDeque<>();
        String[] arr = path.split("/");
        for(String a : arr) {
            if(a.isEmpty() || a.equals("/") || a.equals(".")) {
                continue;
            } else if(a.equals("..")) {
                if(!st.isEmpty()) {
                    st.removeLast();
                }
            } else {
                st.add(a);
            }
        }
        
        for(String ele : st) {
            sb.append("/");
            sb.append(ele);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}