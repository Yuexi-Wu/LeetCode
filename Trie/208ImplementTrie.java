class TrieNode {
    public TrieNode[] links = new TrieNode[26];
    public boolean isEnd;
    public boolean isEnd() {
        return isEnd;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean contains(char c) {
        return links[c-'a'] != null;
    }
    public TrieNode get(char c) {
        return links[c-'a'];
    }
}


class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (!node.contains(cur)) {
                node.links[cur-'a'] = new TrieNode();
            }
            node = node.get(cur);
        }
        node.setEnd();
    }
    
    public TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (node.contains(cur)) {
                node = node.get(cur);
            } else {
                return null;
            }
        }
        return node;
    }
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return searchPrefix(word) != null && searchPrefix(word).isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
