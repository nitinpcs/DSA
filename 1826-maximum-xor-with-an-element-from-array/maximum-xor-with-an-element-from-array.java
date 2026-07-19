class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int[][] q = new int[queries.length][3];
        int ind = 0;
        for(int[] row : queries) {
            q[ind][0] = row[0];
            q[ind][1] = row[1];
            q[ind][2] = ind++;
        }
        Arrays.sort(q, (a,b) -> a[1] - b[1]);

        ind = 0;
        Trie t = new Trie();
        int[] ans = new int[queries.length];
        for(int[] row : q) {
            int range = row[1];
            int index = row[2];
            while(ind < nums.length && nums[ind] <= range) {
                t.insert(nums[ind++]);
            }
            int max = ind == 0 ? -1 : t.findMax(row[0]);
            ans[index] = max;
        }

        return ans;
    }
}

class Trie {
    private Node root;
    Trie() {
        root = new Node();
    }

    void insert(int num) {
        Node node = root;
        for(int i=31; i>=0 ;i--) {
            int bit = (num >> i) & 1;
            if(!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    int findMax(int num) {
        Node node = root;
        int max = 0;
        for(int i=31; i>=0; i--) {
            int bit = (num >> i) & 1;
            if(node.containsKey(1-bit)) {
                max |= (1 << i);
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