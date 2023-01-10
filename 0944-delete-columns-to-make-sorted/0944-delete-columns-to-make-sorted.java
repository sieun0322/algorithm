class Solution {
    public int minDeletionSize(String[] strs) {
        int result = 0;
        for(int col=0; col<strs[0].length(); col++){
            for(int i=1; i<strs.length; i++){
                if(strs[i-1].charAt(col)>strs[i].charAt(col)){
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}