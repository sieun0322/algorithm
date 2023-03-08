class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int right = Integer.MAX_VALUE;
        int left = 0;
        while(left+1<right){
            int mid = (right+left)/2;
            if(complete(piles,mid,h)){
                right = mid;
            }else{
                left = mid;
            }
        }
        return right;
    }
    public static boolean complete(int[] piles, int k, int h){
        long result = 0;
        for(int pile: piles){
            result += pile/k;
            if(pile%k != 0){
                result++;
            }
        }
        return result<=h? true:false;
    }
}