class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            heap.offer(num);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        int resp = 1001;

        for (int num : heap) {
            resp = Math.min(resp, num);
        }

        return resp;
    }
}
