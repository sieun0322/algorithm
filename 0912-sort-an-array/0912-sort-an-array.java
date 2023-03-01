class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    public static void quickSort(int[] nums, int start, int end){
        int pivot = nums[start];
        int left = start;
        int right = end;
        while(left<right){
            while(left<right && nums[right]>=pivot) right--;
            if(left>right) break;
            while(left<right && nums[left]<=pivot) left++;
            if(left>right) break;

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        nums[start] = nums[left];
        nums[left] = pivot;
        
        if(start<left-1){
            quickSort(nums,start,left-1);
        }
        if(left+1<end){
            quickSort(nums,left+1,end);
        }
    }
    
}