class Node {
    int key, value;
    Node prev, next;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    Map<Integer, Node> lru;
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int capacity;

    public LRUCache(int capacity) {
        lru = new HashMap<>();
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(lru.containsKey(key)) {
            Node node = lru.get(key);
            deleteNode(node);
            addAfterHead(node);
            return node.value;
        } else return -1;
    }

    public void put(int key, int value) {
        if(lru.containsKey(key)) {
            Node node = lru.get(key);
            node.value = value;
            deleteNode(node);
            addAfterHead(node);
        } else {
            if(lru.size() == capacity) {
                Node node = tail.prev;
                lru.remove(node.key);
                deleteNode(node);
            }
            Node node = new Node(key, value);
            lru.put(key, node);
            addAfterHead(node);
        }
    }

    public void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void addAfterHead(Node node) {
        Node nodeAfterHead = head.next;
        head.next = node;
        node.prev = head;
        node.next = nodeAfterHead;
        nodeAfterHead.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */