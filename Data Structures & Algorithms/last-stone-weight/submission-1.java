class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> qu = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            qu.offer(stone);
        }

        //smash
        while (qu.size() > 1) {
            int stoneOne = qu.poll();
            int stoneTwo = qu.poll();

            if (stoneOne != stoneTwo) {
                qu.offer(Math.abs(stoneOne - stoneTwo));
            }
        }

        return qu.size()==1 ? qu.peek() : 0;
    }
}
