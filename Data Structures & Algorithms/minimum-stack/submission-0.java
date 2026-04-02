class MinStack {

    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);

        if (val < min) {
            min = val;
        }
    }
    
    public void pop() {
        stack.pop();

        //update min somehow in O(1)
        min = Integer.MAX_VALUE;
        for (int i : stack) {
            if (i < min) {
                min = i;
            }
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
