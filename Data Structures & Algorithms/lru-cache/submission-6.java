class LRUCache {
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int max;

    private class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    } 

    public LRUCache(int capacity) {
        map = new HashMap<>();
        max = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            moveToEnd(key);
            return map.get(key).val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            moveToEnd(key);
            map.get(key).val = value;
        } else {
            Node newNode = new Node(key,value);
            map.put(key, newNode);
            addToEnd(newNode);

            if (map.size() > max) {
                removeHead();
            }
        }
    }

    private void addToEnd(Node node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        node.prev = tail;
        tail.next = node;

        tail = node;
    }

    private void moveToEnd(int key) {
        Node node = map.get(key);

        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        if (tail == node) {
            return;
        }

        if (head == node) {
            head = node.next;
            head.prev = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        node.next = null;
        node.prev = tail;
        tail.next = node;

        tail = node;
    }

    private void removeHead() {
        if (head == null) {
            return;
        }


        if (head == tail) {
            map.remove(head.key);
            head = null;
            tail = null;
            return;
        }

        map.remove(head.key);
        head = head.next;
        head.prev = null;
    }
}
