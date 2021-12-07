package algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;


/**
 * 
 * @author zion 
 * Runtime: 36 ms, faster than 9.63% of Java online submissions for 3Sum Closest.
 * Memory Usage: 38.6 MB, less than 71.02% of Java online submissions for 3Sum Closest.
 */
public class SumClosest_016 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {-1,2,1,-4};
		int t = 1;
		System.out.println(threeSumClosest(num,t));
	}
	
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int sum = nums[0]+nums[1]+nums[2];
		if(nums.length == 3) return sum;
		if(target <= sum) return target;
		sum = nums[nums.length -1]+nums[nums.length -2]+nums[nums.length -3];
		if(sum <= target) return sum;
		
		int result = target;
		boolean isStart = false;
		
		for(int i = 0; i< nums.length-2; i++) {
			for(int left = i+1; left< nums.length-1; left++) {
				for(int right = left+1; right< nums.length; right++) {
					sum = nums[i] + nums[left] + nums[right];
					if(sum == target) {
						return target;
					}
					if(!isStart) {
						result = sum;
						isStart = true;
					}else {
						result = Math.abs(sum - target) < Math.abs(result - target)?sum:result;
					}
				}
			}
		}
        return result;
    }
	public static int binarySearch(int[] nums, int min, int max) {
		
		int start = min;
		int end = max;
		
		int mid = 0;
		
		while(start<end) {
			mid = (start+end)/2;
			
			if(nums[mid] == 0) {
				while(nums[mid] == 0 && mid < nums.length -1){
					mid++;
				}
				return mid;
			}
			if(0< nums[mid]) end = mid-1;
			else start = mid+1;
		}
		
		mid = nums[start]<nums[end]?start:end;
        while(nums[mid]<0 && mid < nums.length-1){
            mid++;
        }
		return mid;
    }
}
