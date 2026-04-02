class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for(int num: piles) {
            max = Math.max(max, num);
        }

        int low = 1, high = max, minRate = max;

        while (low <= high) {
            int rate = low + ((high-low)/2);

            int hoursToEat = 0;

            for (int num : piles) {
                hoursToEat += Math.ceil((double) num / rate);
            }

            if (hoursToEat <= h) {
                minRate = rate;
                high = rate - 1;
            } else {
                low = rate + 1;
            }
        }

        return minRate;
    }
}
