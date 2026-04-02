class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] response = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            int currTemp = temperatures[i];

            if (stack.isEmpty()) {
                stack.push(i);
            } 
            else {
                while(!stack.isEmpty()) {
                    if (currTemp >= temperatures[stack.peek()]) {
                        stack.pop();
                    } else {
                        response[i] = stack.peek() - i;
                        break;
                    }

                }
                stack.push(i);
            }
        }

        return response;
    }
}
