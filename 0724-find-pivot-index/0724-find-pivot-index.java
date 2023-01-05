class Solution {
    public int pivotIndex(int[] nums) {
        
        int leftSum = 0;
        int rightSum = 0;
        
        for(int idx=0; idx<nums.length; idx++) rightSum+=nums[idx];
        for(int idx=0; idx<nums.length; idx++){
            rightSum -= nums[idx];
            if(leftSum == rightSum) return idx;
            leftSum+=nums[idx];
        }
        
        return -1;
        
    }
}