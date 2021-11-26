package algorithm;

import java.util.Stack;

/**
 * 
 * @author zion
 *
 */
public class RegularExpressionMatching_010 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "mississippi"; // output: bab
		String P = "mis*is*ip*."; // output: bab
		System.out.println(isMatch(S,P));
	}

    public static boolean isMatch(String s, String p) {
    	try {
	        int p_idx = 0;
	        char compareChar;
	        for(int idx = 0; idx<s.length(); idx++){
	            compareChar = p.charAt(p_idx);
	            System.out.println(p_idx+":"+idx);
	            System.out.println(compareChar+":"+s.charAt(idx));
	            if(compareChar == '*'||compareChar == '.' || compareChar== s.charAt(idx)){
	            	if(compareChar == '*'){
	            		if(p.charAt(p_idx-1) != '.' && p.charAt(p_idx-1) != s.charAt(idx)) {
		                	p_idx++;
		                	if(idx == s.length()-1) {
		                		compareChar = p.charAt(p_idx);
		                		if(compareChar == '.' || compareChar== s.charAt(idx)){
		                			return true;
		                		}
		                	}
		                }else if(p.charAt(p_idx-1) == '.'){
	            			
	            		}
		            }else {
		            	p_idx++;
		            }
	            }else{
	            	if(idx<s.length()-2) {
	            		if(p.charAt(p_idx+1) == '*') {
	            			p_idx++;
	            			idx--;
	            		}else {
	            			return false;
	            		}
	            	}else {
	            		return false;
	            	}
	            }
	            System.out.println("idx:"+idx);
	            System.out.println("p_idx:"+p_idx);
	            System.out.println("============");
	            if(idx ==s.length()-1 && p_idx > p.length()-1) {
	            	return true;
	            }
	        }
    	}catch(Exception e) {
    		return false;
    	}
        return true;
    }
}
