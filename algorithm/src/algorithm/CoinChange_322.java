package algorithm;

import java.util.Arrays;

public class CoinChange_322 {

    static int[] coins_g;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {411,412,413,414,415,416,417,418,419,420,421,422};
		int amount = 9864;
		
		
		Arrays.sort(coins);
		
        coins_g = coins;
        
        int min = 100000;
        //for(int coinIdx = coins.length-1; coinIdx>=0; coinIdx-- ) {
        	
        	int tempMin = f_minCoinChange(coins.length-1, amount ,0);
        	min = min<tempMin? min:tempMin;
        	
        //}
        
        System.out.println(min);
    }
    public static int f_minCoinChange(int coinIdx, int rest, int count) {
        int min = 100000;
        
        if(rest == 0){
            return count;
        }
        if(rest < 0){
            return -1;
        }
            for(int cType = coinIdx; cType >= 0; cType--){
                
                int max = rest/coins_g[cType];
                //System.out.println("max:"+max+"rest:"+rest+"COIN:"+coins_g[cType]);
                while(max>0){
                   
                	while(min<count + max) {
                		max--;
                	}
                    int temp = f_minCoinChange(cType-1,rest-(coins_g[cType]*max),count + max);
                   
                    if(temp > 0){
                        min = min<temp?min:temp;
                    }
                    max--;
                
                }
                
        }
        return min;
    }
}