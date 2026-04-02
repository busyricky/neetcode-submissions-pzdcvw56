class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] response = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty() || temperatures[stack.peek()] > temperatures[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    int pop = stack.pop();

                    response[pop] = i - pop; 
                }
                stack.push(i);
            }
        }

        return response;
    }
}
