class MinStack {
    Stack<Long> stack;
    long min = 0;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            min = val;
        }

        stack.push(val - min);

        if (val < min) {
            min = val;
        }
    }
    
    public void pop() {
        long top = stack.peek();

        if (top <= 0) {
            min = min - top;
        }

        stack.pop();
    }
    
    public int top() {
        long top = stack.peek();

        if (top > 0) {
            return (int) (top + min);
        } else {
            return (int) min;
        }
    }
    
    public int getMin() {
        return (int) min;
    }
}
