class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r = 1, l = 1, rate = 1;

        // find upper bound (max bananas in pile)
        for (int i : piles) {
            r = Math.max(r, i);
        }

        while (l < r) {
            rate = l + (r-l)/2;

            // check if this rate works
            int counter = 0;
            for (int pile : piles) {
                counter += Math.ceil((double)pile/rate);
                
                // while(currPile > 0) {
                //     currPile -= rate;
                //     counter++;
                // }
            }

            if (counter > h) {  // too slow, look for higher rate
                l = rate + 1;
            } else {            // fast enough, look for possible slower rate
                r = rate;
            }
        }

        return r;
    }
 }
