package algorithm;

import java.util.Stack;

/**
 * 
 * @author zion 
 * Runtime: 3 ms, faster than 86.38% of Java online submissions for Container With Most Water.
 * Memory Usage: 52.5 MB, less than 92.76% of Java online submissions for Container With Most Water.
 *
 */
public class ContainerWithMostWater_011 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = { 1,8,6,2,5,4,8,3,7 }; // output: bab
		System.out.println(maxArea(height));
	}

	public static int maxArea(int[] height) {
	    int max = 0;
        int start = 0;
        int end = height.length - 1;
    
        while (end - start > 0) {
	        int h = height[end] > height[start] ? height[start] : height[end];
	        int size = (end - start) * h;
	        
	        if(height[end] > height[start]){
	        	start++; 
	        }else{ 
	        	end--;
	        }
        max = max < size ? size : max;
        }
        return max;
	}
}
