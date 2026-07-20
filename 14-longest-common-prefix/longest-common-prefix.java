class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie t = new Trie();
        for(String s : strs) t.insert(s);

        return t.lcp(t.root);
    }
}


class Trie {
    Node root ;
    Trie() {
        root = new Node();
    }

    void insert(String word) {
        Node node = root;
        for(char ch : word.toCharArray()) {
            if(!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    String lcp(Node node) {
        StringBuilder sb = new StringBuilder();
        while(true) {
            int count = 0;
            int index = -1;
            for(int i=0; i<26; i++) {
                if(node.child[i] != null) {
                    count++;
                    index = i;
                }
            }
            if(count > 1 || node.isEnd()) break;
            sb.append((char)(index+'a'));
            node = node.get((char)(index+'a'));
        }
        return sb.toString();
    }
}

class Node {
    Node[] child = new Node[26];
    boolean ew = false;

    void put(char ch, Node node) {
        child[ch-'a'] = node;
    }
    boolean containsKey(char ch) {
        return child[ch-'a'] != null;
    }
    Node get(char ch) {
        return child[ch-'a'];
    }
    boolean isEnd() {
        return ew;
    }
    void setEnd() {
        ew = true;
    }
}


