class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }

        int minRate = r;

        while (l <= r) {
            int mid = l + (r-l)/2;

            if (checkRate(mid, piles) <= h) {
                minRate = Math.min(minRate, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return minRate;
    }

    private int checkRate(int rate, int[] piles) {
        int hours = 0;

        for (int i = 0; i < piles.length; i++) {
            int hour =  piles[i] / rate;
            if (piles[i] % rate > 0) {
                hour++;
            }

            hours += hour;
        }

        return hours;
    }
}
