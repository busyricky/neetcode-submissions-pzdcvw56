class LRUCache {
    class Node {
        Node prev;
        Node next;
        int key;
        int val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int max;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        max = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            updateLRU(key);
            return map.get(key).val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
        } else {
            map.put(key, new Node(key, value));
        }

        updateLRU(key);

        if (map.size() > max) {
            removeFirst();
        }
    }

    private void updateLRU(int key) {
        Node curr = map.get(key);

        if (tail == null) {
            head = curr;
            tail = curr;
            return;
        }

        if (curr.prev != null || curr.next != null || curr == head) {
            if (curr == tail) {
                tail = curr.prev;
            }

            if (curr.next != null) curr.next.prev = curr.prev;

            if (curr.prev != null) {
                curr.prev.next = curr.next;
            } else {
                head = curr.next;
            }
        }

        // 🔑 critical fix
    if (tail == null) {
        head = curr;
        tail = curr;
        return;
    }
                

        tail.next = curr;
        curr.prev = tail;
        tail = curr;
        curr.next = null;
    }

    private void removeFirst() {
        if (map.size() == 0) {
            return;
        }

        

        map.remove(head.key);

        if (head.next != null) {
            head.next.prev = null;
        }

        if (head == tail) {
            tail = null;
            head = null;
        } else {
            head = head.next;
        }
    }
}
