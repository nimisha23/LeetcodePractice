class Solution {
    //TC : O(N * MlogM) -> where M is the max length of a string
    //SC: O(N*M)
    // public List<List<String>> groupAnagrams(String[] strs) {
    //     List<List<String>> res = new ArrayList<>();
    //     Map<String, List<String>> map = new HashMap<>();
    //     for(int i = 0; i < strs.length; i++) {
    //         char[] ch = strs[i].toCharArray();
    //         Arrays.sort(ch);
    //         String key = String.valueOf(ch);
    //         if(!map.containsKey(key)) {
    //             map.put(key, new ArrayList<>());
    //         }
    //         map.get(key).add(strs[i]);
    //     }
    //     return new ArrayList<>(map.values());
    // }

//TC : O(N * M)
//SC : O(N*M)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            int[] freq = new int[26];
            char[] ca = strs[i].toCharArray();

            for(int j = 0; j < ca.length; j++) {
                freq[ca[j]-'a']++;
            }
            StringBuilder key = new StringBuilder();
            for(int j = 0; j < 26; j++) {
                key.append(freq[j]).append("#"); //we are using count of all 26 chars to create the key, therefore unique keys even if counts are 1,1,1 for two keys having different characters
            }
            if(!map.containsKey(key.toString())) {
                map.put(key.toString(), new ArrayList<>());
            }
            map.get(key.toString()).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

}