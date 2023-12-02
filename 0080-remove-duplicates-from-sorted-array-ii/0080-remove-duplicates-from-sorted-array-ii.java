class Solution {
    public int removeDuplicates(int[] nums) {
        int s = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i-1] != nums[i]){
                nums[s++] = nums[i];
            } else {
                nums[s++] = nums[i];
                while(i+1<nums.length && nums[i]==nums[i+1]){
                    i++;
                }
            }
        }
        return s;
    }
}