class Solution {
    public int pivotIndex(int[] nums) {
        int rightSum = 0;
        int idx = 0;
        int leftSum = 0;
        for(int num:nums) rightSum+=num;
        while(idx < nums.length){
            rightSum -= nums[idx];
            if(leftSum == rightSum) return idx;
            leftSum+=nums[idx];
            idx++;
        }
        return -1;
    }
}