class Solution {
    public int minCost(String colors, int[] neededTime) {
        int result = 0;
        for(int i=1; i<colors.length(); i++){
            if(colors.charAt(i-1) == colors.charAt(i)){
                int maxTime = neededTime[i-1];
                int sum = neededTime[i-1];
                while(i<colors.length() && colors.charAt(i-1) == colors.charAt(i)){
                    sum += neededTime[i];
                    if(maxTime < neededTime[i]){
                        maxTime = neededTime[i];
                    }
                    i++;
                }
                result+=(sum-maxTime);
                i--;
            }
           
        }
        return result;
    }
}