class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();

        int[] results = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            int currTemp = temperatures[i];

            while (!stack.isEmpty()) {
                if (stack.peek()[0] > currTemp) {
                    results[i] = stack.peek()[1] - i;
                    break;
                } else {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                results[i] = 0;
            }

            stack.push(new int[]{currTemp, i});
        }

        return results;
    }
}
