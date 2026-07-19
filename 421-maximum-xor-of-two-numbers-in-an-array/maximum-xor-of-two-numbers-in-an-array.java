class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie t = new Trie();
        for(int e : nums) t.insert(e);
        int max = 0;
        for(int e : nums) max = Math.max(max, t.maxXor(e));

        return max;
    }
}

class Trie {
    Node root ;
    Trie() {
        root = new Node();
    }
    
    void insert(int num) {
        Node node = root;
        for(int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if(!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }
    
    int maxXor(int num) {
        Node node = root;
        int max = 0;
        for(int i=31; i>=0 ; i--) {
            int bit = (num >> i) & 1;
            if(node.containsKey(1-bit)) {
                max = max | (1 << i);
                node = node.get(1-bit);
            }
            else {
                node = node.get(bit);
            }
        }
        return max;
    }
}

class Node {
    
    Node[] links = new Node[2];
    
    void put(int bit, Node node) {
        links[bit] = node;
    }
    
    boolean containsKey(int bit) {
        return links[bit] != null;
    }
    
    Node get(int bit) {
        return links[bit];
    }
}