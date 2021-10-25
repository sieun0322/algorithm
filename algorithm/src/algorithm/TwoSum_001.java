package algorithm;
/**
 * LeetCode 1. Two Sum
 * Easy
 * @author zion
 *
 */
public class TwoSum_001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,7,11,15};
		int target = 9;
		System.out.println("result:"+twoSum(nums,target));
						
	}
	public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = (i+1) ; j < nums.length; j++){
                int sum = nums[i] + nums[j];
                if(sum == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
