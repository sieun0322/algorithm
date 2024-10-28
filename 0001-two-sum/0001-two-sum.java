class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i1 = 0; i1<nums.length; i1++){
             for(int i2 = i1+1; i2<nums.length; i2++){
                if(nums[i1]+nums[i2] == target){
                    return new int[] {i1, i2};
                }
            }
        }
        return new int[2];
    }
}