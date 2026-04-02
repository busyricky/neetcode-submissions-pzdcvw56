class KthLargest {
    PriorityQueue<Integer> qu;
    int kth = 0;

    public KthLargest(int k, int[] nums) {
        qu = new PriorityQueue<>();

        for (int num : nums) {
            qu.add(num);

            if (qu.size() > k) {
                qu.poll();
            }
        }

        kth = k;
    }
    
    public int add(int val) {
        qu.add(val);

        if (qu.size() > kth) {
            qu.poll();
        }

        return qu.peek();
    }
}
