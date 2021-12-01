package algorithm;

import java.util.Stack;

/**
 * 
 * @author zion 
 * Time Limit Exceeded
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
		for (int start = 0; start < height.length; start++) {
			for (int end = 0; end < height.length; end++) {
				int w = end - start;
				int h = height[start] < height[end] ? height[start] : height[end];
				int size = w * h;
				if (size > max)
					max = size;
			}
		}
		return max;
	}

}
