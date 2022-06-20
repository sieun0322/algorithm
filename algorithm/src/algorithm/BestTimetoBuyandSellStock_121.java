package algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * LeetCode 1. Two Sum
 * Easy
 * @author zion
 *
 */
public class BestTimetoBuyandSellStock_121 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] prices = {7,1,5,3,6,4};
		//int[] prices = {7,6,4,3,1};
		//int[] prices = {1,2};
		int[] prices = {1,2,4};
		
		int[] sortNum = Arrays.copyOf(prices, prices.length);
		Arrays.sort(sortNum);
		int maxNum = sortNum[sortNum.length-1];
		int minNum = sortNum[0];
		
		
		int result = 0;
		int buyPrice = prices[0];
		
		if(prices.length<2) {
			result=0;
		}else if(prices.length==2) {
			result=prices[0]<prices[1]?prices[1]-prices[0]:0;
		}else {
			for(int idx = 0; idx<prices.length; idx++) {
				if(result>prices[idx]-minNum) {
					continue;
				}else if(result>prices[idx]) {
					continue;
				}else {
					int tempMax = bestTimetoBuyandSellStock(prices,idx);
						result = result <= tempMax ?tempMax:result;
						buyPrice = result <= tempMax ?prices[idx]:buyPrice;
				}
			}
		}
		System.out.println("result:"+result);
						
	}
	public static int bestTimetoBuyandSellStock(int[] prices,int buyIdx) {
		int max = 0;
		for(int idx = buyIdx+1; idx<prices.length; idx++) {
			if(prices[buyIdx] > prices[idx]) {
				continue;
			}else {
				max = max <=prices[idx] - prices[buyIdx]?prices[idx] - prices[buyIdx]:max;
				
			}
			
		}
        return max;
    }
}
