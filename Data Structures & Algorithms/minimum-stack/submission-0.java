class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.add(val);
        if(minStack.isEmpty()){
            minStack.add(val);
        } else {
            int top = minStack.peek();
            val = Math.min(val, top);
            minStack.add(val);
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();

    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
