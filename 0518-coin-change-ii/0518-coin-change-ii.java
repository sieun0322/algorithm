class Solution {
    public int change(int amount, int[] coins) {
        int[] num = new int[amount+1];
        num[0]=1;
        for(int i=0; i<coins.length; i++){
             for(int j=coins[i]; j<num.length; j++){
                 num[j]+=num[j-coins[i]];
             }
        }
        return num[amount];
    }
}