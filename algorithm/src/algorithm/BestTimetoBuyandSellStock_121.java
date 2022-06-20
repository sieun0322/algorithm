package algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author zion
 * Runtime: 2534 ms, faster than 5.29% of Java online submissions for Best Time to Buy and Sell Stock.
 * Memory Usage: 177.2 MB, less than 5.15% of Java online submissions for Best Time to Buy and Sell Stock.
 */
public class BestTimetoBuyandSellStock_121 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {7,1,5,3,6,4};
		//int[] prices = {7,6,4,3,1};
		//int[] prices = {1,2};
		//int[] prices = {1,2,4};
		
		
		int result = 0;
        int max = -1;
        int minNum = 10000;
        boolean maxChange = true;
        
        for(int idx = 0; idx<prices.length-1; idx++) {
            if(prices[idx] == max){
                maxChange = true;
            }
            if(prices[idx] >= minNum){
                continue;
            }
            minNum = prices[idx] <= minNum ?prices[idx]:minNum;
            if(maxChange){
                int[] arr = Arrays.copyOfRange(prices, idx+1, prices.length);
                max = Arrays.stream(arr).max().getAsInt();  
                maxChange = false;
            }
            result = result <= max-minNum ? max-minNum:result;
        }
		System.out.println("result:"+result);				
	}
}
