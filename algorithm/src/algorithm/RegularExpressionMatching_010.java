package algorithm;

import java.util.Stack;

/**
 * 
 * @author zion FAIL
 *
 */
public class RegularExpressionMatching_010 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String P = "aa"; // output: bab
		String S = "a*"; // output: bab
		System.out.println(isMatch(S, P));
	}

	public static boolean isMatch(String s, String p) {
		try {
			int start_idx = 0;
			int start_p_idx = 0;
			int p_length = 0;
			String compare_p;
			String compare_s = s;
			String last_p = "";
			String last_s = "";
			for (int p_idx = 0; p_idx < p.length(); p_idx++) {

				if (p.charAt(p_idx) == '*') {
					String pre_p = p.substring(start_p_idx, p_idx - 1);
					int s_index = compare_s.indexOf(pre_p);
					if (s_index == -1) {
						return false;
					} else {
						if("".equals(pre_p)) {
							
						}else {
						String insert = "";
						int cnt =0;
						while(cnt < pre_p.length()) {
							insert+="#";
							cnt++;
						}
						compare_s=compare_s.substring(0,s_index)+insert+compare_s.substring(s_index+2);
						}
						String current_p = p.substring(p_idx - 1, p_idx + 1);

						if (last_p.length() >= 2
								&& current_p.equals(last_p.substring(last_p.length() - 2, last_p.length()))) {
							
						}else {
							
							last_p += current_p;
						}
						start_p_idx = s_index + pre_p.length()+2;
						
					}
				} else if (p.charAt(p_idx) == '.') {
					
					if(p_idx <p.length()-1 && "*".equals(p.substring(p_idx+1,p_idx+2))) {
						
					}else {
						last_p+=".";
					}
				}

			}
			compare_s = compare_s.replaceAll("#", "");
			System.out.println("P"+last_p);
			System.out.println(compare_s);
			start_p_idx = 0;
			for(int idx = 0; idx<compare_s.length(); idx++) {
				System.out.println("===============");
				System.out.println(last_p);
				System.out.println(compare_s);
				if(start_p_idx>last_p.length()-1) return false;
				int s_char = compare_s.charAt(idx);
				int p_char = last_p.charAt(start_p_idx);
				
				System.out.println("4:"+Character.toString(p_char));
				System.out.println("4:"+Character.toString(s_char));
				if(p_char == '*') {
					char pre_p = last_p.charAt(start_p_idx-1);
					if(pre_p == s_char) {
						int temp_idx = idx;
						while(pre_p == s_char) {
							if(temp_idx < compare_s.length()-1) {
								temp_idx++;
								s_char = compare_s.charAt(temp_idx);
							}
						}
						if(idx!=temp_idx) {
							idx = temp_idx-1;
						}
						start_p_idx++;
					}else {
						
						if(start_p_idx < last_p.length()-1) {
							start_p_idx++;
							p_char = compare_s.charAt(start_p_idx);
							if(p_char =='.' || p_char == s_char) {
								start_p_idx++;
							}else {
								return false;
							}
						}else {
							return false;
						}
						
					}
				}else if(p_char == '.') {
					start_p_idx++;
				}else if(p_char == s_char){
					start_p_idx++;
				}else {
					System.out.println("4:"+Character.toString(p_char));
					System.out.println("4:"+Character.toString(s_char));
					return false;
				}
			}
			System.out.println(start_p_idx);
			if(start_p_idx<last_p.length()) {
				return false;
			}
			return true;
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
			return false;
		}
	}

	public int[] solution(String[] record) {
		int[] answer = {};
		return answer;
	}
}
