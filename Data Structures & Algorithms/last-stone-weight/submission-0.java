class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> qu = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            qu.offer(stone);
        }

        return smash(qu);
    }

    private int smash(PriorityQueue<Integer> qu) {
        if (qu.size() == 0) {
            return 0;
        } else if (qu.size() == 1) {
            return qu.peek();
        }

        //smash
        int stoneOne = qu.poll();
        int stoneTwo = qu.poll();

        if (stoneOne == stoneTwo) {
            return smash(qu); 
        } else {
            qu.offer(Math.abs(stoneOne - stoneTwo));
            return smash(qu);
        }
    }
}
