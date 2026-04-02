/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) { return null; }

        List<List<Integer>> list = new ArrayList<>();
        Node curr = head;

        int counter = 0;
        
        //take out vals and replace with index. capture vals in list
        while (curr != null) {
            list.add(new ArrayList<>(List.of(curr.val)));
            curr.val = counter;
            counter++;
            curr = curr.next;
        }

        //get the random node's indexes
        curr = head;
        for (int i = 0; i < list.size(); i++) {
            if (curr.random != null) {
                list.get(i).add(curr.random.val);
            }
            curr = curr.next;
        }

        //copy vals to new list
        Node prev = null;
        Map<Integer, Node> map = new HashMap<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            curr = new Node(list.get(i).get(0)); 
            curr.next = prev;
            prev = curr;
            map.put(i, curr);
        }
        Node newHead = prev;

        //add random nodes to pointers
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).size() > 1) {
                prev.random = map.get(list.get(i).get(1));
            }
            prev = prev.next;
        }

        return newHead;
    }
}










