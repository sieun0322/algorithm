package algorithm;

import java.util.Stack;

/**
 * 
 * @author zion Runtime: 9 ms, faster than 8.61% of Java online submissions for
 *         Reverse Integer. Memory Usage: 38.7 MB, less than 5.50% of Java
 *         online submissions for Reverse Integer.
 *
 */
public class ReverseInteger_007 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 1534236469; // output: bab
		System.out.println(reverse(x));
	}

	public static int reverse(int x) {
		String result_s ="";
        boolean minus = false;
        try{
            if(x<0) {x=-x; minus = true;}
            String x_s = Integer.toString(x);
            for(int idx = x_s.length() - 1; idx>=0; idx--){
                result_s += Character.toString(x_s.charAt(idx));
            }
            long result = Integer.parseInt(result_s);
            if(minus) result = 0-result;
            if(Integer.MAX_VALUE<result || Integer.MIN_VALUE>result) 
            	throw new Exception();
            return (int) result;
            
        }catch(Exception e){
            return 0;
        }
	}

}
