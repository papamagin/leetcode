//https://leetcode.com/problems/min-stack/description/

class MinStack {
    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> minStack = new ArrayDeque<>();

    public MianStack() {
        
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.addFirst(val);
            minStack.addFirst(val);
        } else {
            stack.addFirst(val);
            int lastMin = minStack.getFirst();
            minStack.addFirst(Math.min(lastMin, val));
        }
    }
    
    public void pop() {
        stack.removeFirst();
        minStack.removeFirst();
    }
    
    public int top() {
        return stack.getFirst();
    }
    
    public int getMin() {
        return minStack.getFirst();
    }
}
