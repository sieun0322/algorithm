class Solution {
    public int minFlipsMonoIncr(String s) {
        int[] cntArr = new int[s.length()];
        int cnt = 0;
        int n = s.length();
        
        for(int i = n -1; i>=0; i--){
            if(s.charAt(i) == '1') cnt++;
            cntArr[i] = cnt;
        }
        int ans = n-cnt;
        cnt = 0;
        for(int i = 0; i<n; i++){
            if(s.charAt(i) == '0') cnt++;
            cntArr[i]= n - (cntArr[i]+cnt);
            ans = Math.min(cntArr[i],ans);
        }
        return ans;
    }
}