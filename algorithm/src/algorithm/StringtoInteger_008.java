package algorithm;

import java.util.Stack;

/**
 * 
 * @author zion
 * Runtime: 6 ms, faster than 17.91% of Java online submissions for String to Integer (atoi).
 * Memory Usage: 40 MB, less than 10.08% of Java online submissions for String to Integer (atoi).
 *
 */
public class StringtoInteger_008 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "   -42"; // output: bab
		System.out.println(myAtoi(x));
	}

    public static int myAtoi(String s) {
    	if(s.equals("")) return 0;
        //Step1
        for(int idx  = 0; idx<s.length(); idx++){
            if(s.charAt(idx)!=' '){
            	s = s.substring(idx,s.length());
            	break;
            }
        }
       //Step2
        String plus = "";
        for(int idx  = 0; idx<s.length(); idx++){
            if(!"".equals(plus)||s.charAt(idx)!='-' && s.charAt(idx)!='+'){
            	s = s.substring(idx,s.length());
                break;
            }
            plus = s.substring(idx,idx+1);
        }
        //Step3
        for(int idx  = 0; idx<s.length(); idx++){
        	
        	int zero = '0';
        	int nine = '9';
        	int s_char = s.charAt(idx);
            if(s_char<zero || s_char>nine){
            	if(idx == 0) {
            		s="0";
            	}else {
            		s = plus+s.substring(0,idx);
            	}
                break;
            }
            if(idx == s.length()-1) {
        		s=plus+s;
        		break;
        	}
        }
        try {
        	int s_int=Integer.parseInt(s);
        	return s_int;
        }catch(Exception e) {
        	if("-".equals(plus)) {
                return Integer.MIN_VALUE;
        	}else {
                return Integer.MAX_VALUE;
        	}
        }
    }
}
