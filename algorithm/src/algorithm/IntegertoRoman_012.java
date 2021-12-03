package algorithm;

import java.util.Stack;

/**
 * 
 * @author zion 
 * Runtime: 28 ms, faster than 5.48% of Java online submissions for Integer to Roman.
 * Memory Usage: 39.4 MB, less than 46.20% of Java online submissions for Integer to Roman.
 *
 */
public class IntegertoRoman_012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = { 1,8,6,2,5,4,8,3,7 };
		System.out.println(intToRoman(3));
	}
	static String one="";
	static String five="";
	
	public static String intToRoman(int num) {
		String result = "";
        int ten = 0;
        String[] symbol = {"I","V","X","L","C","D","M",""};
        while (num>0){
            ten++;
            one = symbol[ten*2-2];
            five = symbol[ten*2-1];
            
            int rest = num %10;
            num = (num-rest)/10;
            if(ten == 1){
                
                if(rest == 4){
                    result = "IV"+result;
                }else if(rest == 9){
                    result = "IX"+result;
                }else {
                	result = standardRoman(rest)+result;
                    
                }
            }else if(ten == 2){
                if(rest == 4){
                    result = "XL"+result;
                }else if(rest == 9){
                    result = "XC"+result;
                }else {
                	result = standardRoman(rest)+result;
                }
            }else if(ten == 3){
                if(rest == 4){
                    result = "CD"+result;
                }else if(rest == 9){
                    result = "CM"+result;
                }else {
                	result = standardRoman(rest)+result;
                }
            }else if(ten == 4){
            	result = standardRoman(rest)+result;
            }
        }
        return result;
	}
	public static String standardRoman(int num) {
		String roman ="";
		if(num <5){
            while(num>0){
            	roman += one;
            	num--;
            }
        }else if(num ==5){
        	roman = five;
        }else{
            while(num>5){
            	roman += one;
                num--;
            }
            roman = five+roman;
        }
		return roman;
	}

}
