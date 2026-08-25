class Trie {
    Node node;
    public Trie() {
        node = new Node();
    }
    
    public void insert(String word) {
        node.insert(word);
    }
    
    public boolean search(String word) {
        return node.search(word);
    }
    
    public boolean startsWith(String prefix) {
        return node.startsWith(prefix);
    }
}

class Node {
    Node[] f ;
    boolean isEnd ;
    Node() {
        f = new Node[26];
        isEnd = false;
    }

    void insert(String word) {
        Node curr = this;
        for(char ch : word.toCharArray()) {
            if(curr.f[ch-'a'] == null) curr.f[ch-'a'] = new Node();
            curr = curr.f[ch-'a'];
        }
        curr.isEnd = true;
    }

    boolean search(String word) {
        Node curr = this;
        for(char ch : word.toCharArray()) {
            if(curr.f[ch-'a'] == null) return false;
            curr = curr.f[ch-'a'];
        }
        return curr.isEnd;
    }

    boolean startsWith(String prefix) {
        Node curr = this;
        for(char ch : prefix.toCharArray()) {
            if(curr.f[ch-'a'] == null) return false;
            curr = curr.f[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */