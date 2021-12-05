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
 * Runtime: 255 ms, faster than 26.40% of Java online submissions for 3Sum.
 * Memory Usage: 43.9 MB, less than 37.66% of Java online submissions for 3Sum.
 *
 */
public class Sum_015 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = { -1,0,1,2,-1,-4 };
		System.out.println(threeSum(height));
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		HashSet<List<Integer>> result = new HashSet<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		
		Arrays.sort(nums);
        int plusStartIndex = -1;
        
		for(int i = 0; i<nums.length; i++) {
            if(nums[i] > 0){
                if(plusStartIndex == -1) {
                    plusStartIndex = i;
                }else{
                    break;
                }
            }
        }
        
		for(int i = 0; i<plusStartIndex; i++) {
            int i_num = nums[i];
            
            int startIndex = i+1;
            int endIndex = nums.length -1;
            
            while(startIndex<endIndex) {
                int j_num = nums[startIndex];
                int k_num = nums[endIndex];
                int sum = i_num+j_num+k_num;
                
	            if(sum == 0) {
					temp = new ArrayList<Integer>();
					temp.add(i_num);
					temp.add(j_num);
					temp.add(k_num);
					temp.sort(null);
					result.add(temp);
                    
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
}
