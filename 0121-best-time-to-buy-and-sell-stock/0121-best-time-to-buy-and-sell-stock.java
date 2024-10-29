class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int temp = 0;
        int[] maxVals = new int[prices.length];
        maxVals[prices.length-1] = prices[prices.length-1];
        for(int i=prices.length-2; i>=0; i--){
            maxVals[i] = prices[i] > maxVals[i+1]?prices[i]:maxVals[i+1];
        }
        for(int i=0; i<prices.length-1; i++){
            if(result < maxVals[i+1]-prices[i]){
                  result =  maxVals[i+1]-prices[i];
            }
        }
        return result;
    }
}