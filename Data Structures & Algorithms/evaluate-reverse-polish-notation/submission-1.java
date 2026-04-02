class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String s : tokens) {
            if (s.equals("+")) {
                int tmp = stack.pop();
                stack.push(stack.pop() + tmp);
            } else if (s.equals("-")) {
                int tmp = stack.pop();
                stack.push(stack.pop() - tmp);
            } else if (s.equals("/")) {
                int tmp = stack.pop();
                stack.push(stack.pop() / tmp);
            } else if (s.equals("*")) {
                int tmp = stack.pop();
                stack.push(stack.pop() * tmp);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.peek();
    }
}
