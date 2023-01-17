class Solution {
    public int minFlipsMonoIncr(String s) {
        int[] cntArr = new int[s.length()];
        int cnt = 0;
        
        for(int i = s.length() -1; i>=0; i--){
            if(s.charAt(i) == '1'){
                cnt++;
            }
            cntArr[i] = cnt;
        }
        int ans = s.length()-cnt;
        cnt = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '0'){
                cnt++;
            }
            cntArr[i]= s.length() - (cntArr[i]+cnt);
            if(cntArr[i]<ans) ans = cntArr[i];
        }
        return ans;
    }
}