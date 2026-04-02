class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 1) {
            return 1;
        }

        //contains <intial_position, hours_to_target>
        // inital_position is unique
        Map<Integer,Double> map = new HashMap<>();

        for (int i = 0; i < position.length; i++) {
            double hoursToTarget = (double) (target - position[i]) / (speed[i]);
            map.put(position[i], hoursToTarget);
        }

        Arrays.sort(position);

        int i = position.length - 1, response = 1;
        //this contains the current limiting time
        double limitingTime = map.get(position[i]);
        
        while (i > 0) {
            int x = position[i];
            int y = position[i-1];

            if (map.get(y) > limitingTime) {
                response++;
                limitingTime = map.get(y);
            }

            i--;
        }

        return response;
    }
}
