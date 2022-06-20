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
 * Runtime: 31 ms, faster than 46.20% of Java online submissions for 3Sum.
 * Memory Usage: 43.6 MB, less than 43.35% of Java online submissions for 3Sum.
 */
public class Sum_015 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { -1,0,1,2,-1,-4 };
		System.out.println(threeSum(num));
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		HashSet<List<Integer>> result = new HashSet<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		
		Arrays.sort(nums);
        //0에 가장 가까운 양수 구하기
        int plusStartIndex = -1;
        
        int minIdx = 0;
        int maxIdx = nums.length -1;
        
        try{
            if(nums.length>2){
                //같은 값
                if(nums[0] == nums[nums.length -1]){
                    if(nums[0] == 0) {
                        temp = new ArrayList<Integer>();
                        temp.add(0);
                        temp.add(0);
                        temp.add(0);
                        result.add(temp);
                    }
                    return new ArrayList(result);
                }
                while(minIdx+2<maxIdx){
                    if((nums[minIdx]+2*nums[maxIdx])<0){
                        minIdx++;
                    }
                    else if((2*nums[minIdx]+nums[maxIdx])>0){
                        maxIdx--;
                    }else{
                        break;
                    }
                }
                plusStartIndex = binarySearch(nums,minIdx,maxIdx);
            }
        }catch(Exception e){
            return new ArrayList(result);
        }
        int i_num = -1;
        int j_num = -1;
        int k_num = -1;
        
        int startIndex = -1;
        int endIndex = -1;
        int sum = -1;
        
		for(int i = minIdx; i<plusStartIndex; i++) {
            i_num = nums[i];
            
            startIndex = i+1;
            endIndex = maxIdx;
            
            
            while(startIndex<endIndex) {
                j_num = nums[startIndex];
                k_num = nums[endIndex];
                sum = i_num+j_num+k_num;
                
	            if(sum == 0) {
					temp = new ArrayList<Integer>();
					temp.add(i_num);
					temp.add(j_num);
					temp.add(k_num);
					result.add(temp);
                    
                    while(startIndex<endIndex 
                          && nums[startIndex] == nums[startIndex+1]) startIndex++;
                    while(startIndex<endIndex 
                          && nums[endIndex] == nums[endIndex-1]) endIndex--;
                    startIndex++;
                    endIndex--;
				}else if(sum > 0) {
					endIndex--;
				} else if(sum < 0) {
					startIndex++;
				} 
            }
			
		}
		return new ArrayList(result);
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
