class Trie {
    TrieNode root;
    TrieNode temp;
    public Trie() {
        root = new TrieNode();
        temp = root;
    }
    
    public void insert(String word) {
        temp = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(temp.children[ch-'a'] == null) {
                TrieNode node = new TrieNode(ch);
                temp.children[ch-'a'] = node;
            }
            temp = temp.children[ch-'a'];
            if(i == word.length()-1) {
                temp.isWord = true;
            }
        }
    }
    
    public boolean search(String word) {
        temp = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(temp.children[ch-'a'] == null) {
                return false;
            }
            temp = temp.children[ch-'a'];
        }
        return temp.isWord == true;
    }
    
    public boolean startsWith(String prefix) {
        temp = root;
        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(temp.children[ch-'a'] == null) {
                return false;
            }
            temp = temp.children[ch-'a'];
        }
        return true;
    }
}

class TrieNode {
    char ch;
    boolean isWord;
    TrieNode[] children = new TrieNode[26];

    public TrieNode() {}
    public TrieNode(char ch) {
        this.ch = ch;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */