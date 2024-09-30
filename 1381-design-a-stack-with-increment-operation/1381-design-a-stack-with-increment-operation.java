class CustomStack {
    int mSize = 0;
    Stack<Integer> s = new Stack<Integer>();
    
    public CustomStack(int maxSize) {
        mSize = maxSize;
        s = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(s.size() < mSize){
            s.push(x);
        }
    }
    
    public int pop() {
        if(s.size() == 0){
            return -1;
        }
       return s.pop();
    }
    
    public void increment(int k, int val) {
        Stack<Integer> tmp  = new Stack<Integer>();
        while(!s.empty()){
            if(s.size()<=k){
                tmp.push(s.pop()+val);
            }else{
                tmp.push(s.pop());
            }
        }
        while(!tmp.empty()){
            s.push(tmp.pop());
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */