class LRUCache {
    class Node {
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insertToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            remove(map.get(key));
        }
        if(map.size() == capacity) {
            remove(tail.prev);
        }
        Node node = new Node(key, value);
        insertToHead(node);
    }

    void remove(Node node) {
        map.remove(node.key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    void insertToHead(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */