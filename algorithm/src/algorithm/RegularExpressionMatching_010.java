package algorithm;

import java.util.Stack;

/**
 * 
 * @author zion 
 * FAIL
 *
 */
public class RegularExpressionMatching_010 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String P = "a*"; // output: bab
		String S = "aa"; // output: bab
		System.out.println(isMatch(S, P));
	}

	public static boolean isMatch(String s, String p) {
		try {
			int start_idx = 0;
			int start_p_idx = 0;
			int p_length = 0;
			String compare_p;
			String compare_s;
			for (int p_idx = 0; p_idx <p.length(); p_idx++) {
				System.out.println("============");
				System.out.println("p_idx:" + p_idx);
				compare_s = s.substring(start_idx,start_idx+1);
				compare_p = p.substring(p_idx,p_idx+1);
				System.out.println("S:" + compare_s);
				System.out.println("P:" + compare_p);
				String post_p  ="";
				if(p_idx <p.length()-1) {
				post_p= p.substring(p_idx+1,p_idx+2);
				}
				if (p.charAt(p_idx) == '*') {
					String pre_p  = p.substring(p_idx-1,p_idx);
					if(pre_p.equals(compare_s)) {
						start_idx++;
						compare_s = s.substring(start_idx,start_idx+1);
						while(pre_p.equals(compare_s)) {
							start_idx++;
							compare_s = s.substring(start_idx,start_idx+1);
						}
					}else {
						start_idx++;
					}
				}else if (p.charAt(p_idx) == '.') {
					
				}else {
					
					if(compare_p.equals(compare_s)) {
						start_idx++;
					}else if(post_p.equals("*")) {
						start_idx++;
					}else {
						return false;
					}
				}
				
			}
			if(start_idx<s.length()) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public int[] solution(String[] record) {
	        int[] answer = {};
	        return answer;
	    }
}
