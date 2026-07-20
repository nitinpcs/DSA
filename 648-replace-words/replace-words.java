class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie t = new Trie();
        for(String s : dictionary) t.insert(s);

        String[] strs = sentence.split(" ");
        String[] ans = new String[strs.length];

        for(int i=0; i<strs.length; i++) {
            ans[i] = t.getRoot(t.root, strs[i]);
        }
        return String.join(" ", ans);
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

    String getRoot(Node node, String word) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(!node.isEnd() && i < word.length()) {
            char ch = word.charAt(i++);
            if(node.child[ch-'a'] != null) {
                sb.append(ch);
                node = node.get(ch);
            }
            else{
                return word;
            }
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

