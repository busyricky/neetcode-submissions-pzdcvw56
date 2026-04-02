class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node() {}
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer,Node> map = new HashMap<>();
    int max = 0;
    Node head, tail;

    public LRUCache(int capacity) {
        max = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            moveToEnd(map.get(key));
            return map.get(key).val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            moveToEnd(map.get(key));
            map.get(key).val = value;
        } else {
            Node node = new Node(key,value);
            putAtEnd(node);
            map.put(key, node);
        }

        if (map.size() > max) {
            removeFirst();
        }
    }

    private void moveToEnd(Node node) {  // move existing node to end
        if (node == tail) {
            return;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }
        
        if (node.next != null) {
            node.next.prev = node.prev;
        }

        if (node == head) {
            head = node.next;
        }

        if (tail != null) {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        node.next = null;
    }

    private void putAtEnd(Node node) {   // new node, add to end
        if (head == null) {
            head = node;
        }

        if (tail == null) {
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

    }

    private void removeFirst() {         // remove first node in list & map
        if (head != null) {
            map.remove(head.key);
            head = head.next;

            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        }
    }
}
