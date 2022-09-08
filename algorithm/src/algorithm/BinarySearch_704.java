package algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author zion
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Search.
 * Memory Usage: 54.5 MB, less than 39.93% of Java online submissions for Binary Search.
 */
public class BinarySearch_704 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,0,3,5,9,12};
		int target = 9;
		
		int result = binarySearch(nums,0,nums.length-1,target);
		System.out.println("result:"+result);				
	}
	public static int binarySearch(int[] numbers,int startIdx,int endIdx, int t){
        if(startIdx<0 || endIdx>=numbers.length || startIdx > endIdx){
            return -1;
        }
        if(numbers[startIdx] == t){
            return startIdx;
        }
        if(numbers[endIdx] == t ){
            return endIdx;
        }
        int mid = startIdx + (endIdx - startIdx)/2;
        if(numbers[mid] == t){
            return mid;
        }else if(numbers[mid]<t){
            return binarySearch(numbers,mid+1,endIdx,t);
        }else if(numbers[mid]>t){
            return binarySearch(numbers,startIdx,mid-1,t);
        }
        
        return -1;
    }
}
