class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minSoFar;

    public MinStack() {
        stack = new Stack<>();
        minSoFar = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);

        if (minSoFar.isEmpty() || (minSoFar.peek() >= val)) {
            minSoFar.push(val);
        }
    }
    
    public void pop() {
        int val = stack.pop();

        if (!minSoFar.isEmpty() && (minSoFar.peek() == val)) {
            minSoFar.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minSoFar.peek();
    }
}
