package algorithm;

import java.util.Arrays;

public class CoinChange_322 {

    static int[] coins_g;
    static int amount_g;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {411,412,413,414,415,416,417,418,419,420,421,422};
		int amount = 9864;
		
		
		Arrays.sort(coins);
        coins_g = coins;
        amount_g = amount;
        int min = coinChange(coins.length, 0,0);
        
        min = min == 100000? -1:min;
        
        System.out.println(min);
        
        
    }
    public static int coinChange(int coinIdx, int sum, int count) {
        int min = 100000;
        if(sum > amount_g){
            return -1;
        }else{
            if(sum == amount_g){
                return count;
            }
            for(int cType = coinIdx-1; cType >= 0; cType--){
                
                int max = (amount_g-sum)/coins_g[cType];
                
                while(max>=0){
                   while(cType>0 && (amount_g-(sum + coins_g[cType]*max))<coins_g[cType-1])  {
                        cType--;
                    }
                    int result = coinChange(cType,sum + coins_g[cType]*max,count + max);
                    if(result > 0){
                        min = min> result ? result:min;
                    }
                    max--;
                
                }
                
            }
        }
        return min;
    }
}