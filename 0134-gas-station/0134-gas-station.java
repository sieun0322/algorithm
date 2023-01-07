class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        if(gas.length == 1 && gas[0] == cost[0]) return 0;
        for(int g=0; g<gas.length; g++){
            while(gas[g]<=cost[g]){
                g++;
                if(g == gas.length) return -1;
            }
            int idx = g;
            total = 0;
            while(true){
                total += (gas[idx]-cost[idx]);
                if(total<0) break;
                
                idx++;
                if(idx>=gas.length) idx=0;
                if(idx==g) return g;
            }
        }
        return -1;
    }
}