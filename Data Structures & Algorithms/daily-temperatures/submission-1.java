class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] response = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            int j = i + 1;

            while (j < temperatures.length) {
                if (temperatures[j] > temperatures[i]) {
                    response[i] = j - i;
                    break;
                } else if (response[j] == 0) {
                    break;
                } else {
                    j = j + response[j];
                }
            }
        }

        return response;
    }
}
