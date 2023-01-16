class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList();
        int START = 0;
        int END = 0;
        int i = 0;
        int[] curItvl;
            
        if(intervals.length ==0) {
            ans.add(newInterval);
        }else{
            curItvl = intervals[0];
            
            for(;i<intervals.length; i++){
                curItvl = intervals[i];
                if(curItvl[1]<newInterval[0]) {
                    ans.add(curItvl);
                }else{break;}
            }
            if(newInterval[0]<curItvl[0]|| i==intervals.length){
                START = newInterval[0];
            }else {
                START = curItvl[0];
            }

            for(;i<intervals.length; i++){
                curItvl = intervals[i];
                if(curItvl[1]<newInterval[1]) {
                }else{break;}
            }
            if(newInterval[1]<curItvl[0] || i==intervals.length){
                END = newInterval[1];
                i--;
            }else {
                END = curItvl[1];
            }
            newInterval[0] = START;
            newInterval[1] = END;
            ans.add(newInterval);
            for(int l = i+1; l<intervals.length; l++){
                ans.add(intervals[l]);
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}