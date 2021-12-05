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
 * 
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
        //int plusEndIndex = -1;
        
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
            
            int startIndex = -1;
            int endIndex = -1;
            
			for(int j = i+1; j<nums.length-1; j++) {
                int j_num = nums[j];
                if(i_num + j_num < 0){
                    startIndex = j+1<plusStartIndex?plusStartIndex:j+1;
                    endIndex = nums.length;
                }else if(i_num + j_num == 0){
                    if(j+1>plusStartIndex-1){
                        break;
                    }
                    startIndex = plusStartIndex-1;
                    endIndex = startIndex+1;
                }else{
                    break;
                }
				for(int k = startIndex; k<endIndex; k++) {
                    int k_num = nums[k];
                    if(i_num+j_num+k_num>0) break;
					if(i_num+j_num+k_num == 0) {
						temp = new ArrayList<Integer>();
						temp.add(i_num);
						temp.add(j_num);
						temp.add(k_num);
						temp.sort(null);
						result.add(temp);
                        break;
					}
                    if(nums[0] == nums[nums.length-1]) return new ArrayList(result);
				}
			}
		}
		return new ArrayList(result);
    }
	public static boolean compare(List<List<Integer>> list,List<Integer> t ) {
		if(list.isEmpty()) return true;
		for(int i = 0; i<list.size(); i++) {
			List<Integer> row = list.get(i);
			System.out.print(row.get(0)+":"+t.get(0)+",");
			System.out.print(row.get(1)+":"+t.get(1)+",");
			System.out.print(row.get(2)+":"+t.get(2)+",");
			if(row.get(0)==t.get(0) && row.get(1)==t.get(1)&& row.get(2)==t.get(2)) {
				return false;
			}else {
				return true;
			}
		}
		return true;
	}

}
