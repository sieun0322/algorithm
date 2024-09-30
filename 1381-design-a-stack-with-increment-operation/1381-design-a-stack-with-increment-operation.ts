class CustomStack {
    private stk: number[];
    private add: number[];
    private i: number;

    constructor(maxSize: number) {
        this.stk = Array(maxSize).fill(0);
        this.add = Array(maxSize).fill(0);
        this.i = 0;
    }

    push(x: number): void {
        if (this.i < this.stk.length) {
            this.stk[this.i++] = x;
        }
    }

    pop(): number {
        if (this.i <= 0) {
            return -1;
        }
        let val = this.stk[--this.i];
        this.stk[this.i] = 0;
        return val;
    }

    increment(k: number, val: number): void {
        let idx = 0;
        while (idx < k) {
            this.stk[idx++]+= val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * var obj = new CustomStack(maxSize)
 * obj.push(x)
 * var param_2 = obj.pop()
 * obj.increment(k,val)
 */