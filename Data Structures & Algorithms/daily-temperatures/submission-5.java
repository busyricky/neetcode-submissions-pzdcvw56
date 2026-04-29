class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] resp = new int[temperatures.length];

        Stack<Pair<Integer,Integer>> stack = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            int temp = temperatures[i];

            while (!stack.isEmpty() && stack.peek().getKey() <= temp) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                resp[i] = 0;
            } else {
                resp[i] = stack.peek().getValue() - i;
            }

            stack.push(new Pair<>(temp,i));
        }

        return resp;
    }
}
