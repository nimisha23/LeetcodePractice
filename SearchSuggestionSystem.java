class TrieNode {
    char ch;
    TrieNode[] children = new TrieNode[26];
    boolean isWord;

    public TrieNode() {}
    public TrieNode(char ch){
        this.ch = ch;
        isWord = false;
    }
};
class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            if(node.children[ch-'a'] == null) {
                node.children[ch-'a'] = new TrieNode(ch);
            }
            node = node.children[ch-'a'];
        }
        node.isWord = true;
    }

    public List<String> findWordsWithGivenPrefix(String prefix) {
        TrieNode node = root;
        List<String> res = new ArrayList<>();
        for(char ch : prefix.toCharArray()) {
            if(node.children[ch-'a'] == null) {
                return res;
            } else {
                node = node.children[ch-'a'];
            }
        }
        dfs(node, res, prefix);
        return res;
    }
    void dfs(TrieNode node, List<String> res, String prefix) {
        if(res.size() == 3) return;
        if(node.isWord) {
            res.add(prefix);
        } 
        //dfs
        for(char ch = 'a'; ch <= 'z'; ch++) {
            if(node.children[ch-'a'] != null)
                dfs(node.children[ch-'a'], res, prefix + ch); //we are doing prefix + ch, because if we find word money with prefix MON and there exist word mones, then we want to take that as well, instead of let's say monitor which would be after money for prefix mon -> MONey, MONitor
        }
    }
};
class Solution {
    //TC : O(NlogN) + O(MlogN) -> NlogN for sorting products and MlogN for each char of searchWord we are doing binary search, if we assume length of sw as M
    // public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    //     Arrays.sort(products);
    //     List<List<String>> result = new ArrayList<>();
    //     int index = 0; int n = products.length;
    //     StringBuilder sb = new StringBuilder();
    //     for(char ch : searchWord.toCharArray()) {
    //         sb.append(ch);
    //         index = lowerBound(products, sb.toString(), index);
    //         List<String> list = new ArrayList<>();
    //         for (int i = index; i < Math.min(index + 3, n); i++) {
    //             if (products[i].length() < sb.length() || !products[i].substring(0, sb.length()).equals(sb.toString()))
    //                 break;
    //                 list.add(products[i]);
    //         }
    //         result.add(list);
    //     }
    //     return result;
    // }

    // public int lowerBound(String[] products, String prefix, int start) {
    //     int low = start; int high = products.length-1;
    //     int index = start;
    //     while(low <= high) {
    //         int mid = low + (high-low)/2;
    //         if(products[mid].compareTo(prefix) >= 0) { //imp : we don't use startsWith here because then we won't know which direction to go to, when we use compareTo then we know if prefix is smaller or larger than the current word
    //             index = mid;
    //             high = mid-1;
    //         } else {
    //             low = mid+1;
    //         }
    //     }
    //     return index;
    // }

//TC : O(W)(build trie) + O(M*W): where W is the total no of characters in products array and M is the len of prefix
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Trie trie = new Trie();
        for(String p : products) {
            trie.insert(p);
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : searchWord.toCharArray()) {
            sb.append(ch);
            List<String> res = trie.findWordsWithGivenPrefix(sb.toString());
            result.add(res);
        }
        return result;
    }
};
    
