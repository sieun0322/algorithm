class MyQueue {
    Stack<Integer> stk;
    Stack<Integer> rvs;
    public MyQueue() {
        stk= new Stack<>();
        rvs= new Stack<>();
    }
    
    public void push(int x) {
        stk.push(x);
    }
    
    public int pop() {
        while(stk.size()>1){
            rvs.push(stk.pop());
        }
        int val = stk.pop();
        while(rvs.size()>0){
            stk.push(rvs.pop());
        }
        return val;
    }
    
    public int peek() {
        while(stk.size()>1){
            rvs.push(stk.pop());
        }
        int val = stk.peek();
        while(rvs.size()>0){
            stk.push(rvs.pop());
        }
        return val;
    }
    
    public boolean empty() {
        return stk.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */