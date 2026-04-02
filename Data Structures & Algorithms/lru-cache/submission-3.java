class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node() {}
        Node(int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    Map<Integer,Node> map = new HashMap<>();
    Node tail, head;
    int max = 0;

    public LRUCache(int capacity) {
        max = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            updateNode(key);
            return map.get(key).val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
            updateNode(key);
        } else {
            Node newNode = new Node(key, value, tail, null);
            map.put(key, newNode);

            if (head == null) {
                head = newNode;
            }

            if (tail != null) {
                tail.next = newNode;
            }

            tail = newNode;
        }

        if (map.size() > max) {
            removeLRU();
        }
    }

    private void updateNode(int key) {
        //send node to tail
        Node curr = map.get(key);

        if (tail == curr) {
            return;
        }

        if (head == curr) {
            head = curr.next;
        }

        if (curr.prev != null) {
            curr.prev.next = curr.next;
        }
        if (curr.next != null) {
            curr.next.prev = curr.prev;
        }

        tail.next = curr;
        curr.prev = tail;

        curr.next = null;
        tail = curr;     
    }

    private void removeLRU() {
        map.remove(head.key);
        head = head.next;
    }
}
