class Solution {
    //Below solution gives TLE
    // Set<String> res;
    // public int countPalindromicSubsequence(String s) {
    //     res = new HashSet<>();
    //     helper(0, new StringBuilder(), s);
    //     return res.size();
    // }

    // public void helper(int index, StringBuilder sb, String s) {
    //     if(sb.length() == 3 && isPalindrome(sb.toString())) {
    //         res.add(sb.toString());
    //         return;
    //     }

    //     for(int i = index; i < s.length(); i++) {
    //         sb.append(s.charAt(i));
    //         helper(i+1, sb, s);

    //         sb.deleteCharAt(sb.length()-1);
    //         helper(i+1, sb, s);
    //     }
    // }

    // public boolean isPalindrome(String s) {
    //     return s.charAt(0) == s.charAt(2);
    // }
    //TC : O(n)
    //SC : O(1)
    // public int countPalindromicSubsequence(String s) {
    //     HashSet<Character> letters = new HashSet<>();
    //     int count = 0;
    //     for(Character ch : s.toCharArray()) {
    //         letters.add(ch);
    //     }

    //     for(Character ch : letters) { //max letters can be 26, english lowercase letters
    //         HashSet<Character> midLetter = new HashSet<>();
    //         int i = -1; //start index of the letter in the string
    //         int j = 0; //end index of the letter in the string

    //         for(int k = 0; k < s.length(); k++) {
    //             if(s.charAt(k) == ch) {
    //                 if(i == -1) {
    //                     i = k;
    //                 }
    //                 j = k;
    //             }
    //         }

    //         for(int k = i+1; k < j; k++) {
    //             midLetter.add(s.charAt(k));
    //         }
    //         count += midLetter.size();
    //      }
    //      return count;
    // }

    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        Arrays.fill(first, -1);
        int[] last = new int[26];
        int count = 0;
        for(int k = 0; k < s.length(); k++) {
            int ch = s.charAt(k)-'a';
            if(first[ch] == -1) {
                first[ch] = k;
            }
            last[ch] = k;
        }

        for(int i = 0; i < 26; i++){
            if(first[i] != -1) {
                HashSet<Character> set = new HashSet<>();
                for(int k = first[i]+1; k < last[i]; k++) {
                    set.add(s.charAt(k));
                }
                count += set.size();
            }
        }
        return count;
    }


    
}