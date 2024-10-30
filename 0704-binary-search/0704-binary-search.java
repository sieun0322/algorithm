class Solution {
    public int search(int[] nums, int target) {
        int sIdx = 0;
        int eIdx = nums.length-1;
        
        while(sIdx<=eIdx){
            if(nums[sIdx]== target) return sIdx;
            if(nums[eIdx]== target) return eIdx;
            int mid = (sIdx+eIdx)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]<target){
                sIdx = mid+1;
            }else if(nums[mid]>target){
                eIdx = mid-1;
            }
        }
        return -1;
    }
}