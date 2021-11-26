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

		String P = "mis*is*ip*."; // output: bab
		String S = "mississippi"; // output: bab
		System.out.println(isMatch(S, P));
	}

	public static boolean isMatch(String s, String p) {
		try {
			int p_idx = 0;
			char compareChar;
			for (int idx = 0; idx < s.length(); idx++) {
				compareChar = p.charAt(p_idx);

				System.out.println("============");
				System.out.println(p_idx + ":" + compareChar);
				System.out.println(idx + ":" + s.charAt(idx));
				if (compareChar == '*') {
					compareChar = p.charAt(p_idx-1);
					if (compareChar == s.charAt(idx)) {
						
					} else if (compareChar == '.') {
						
					} else {
						p_idx++;
						if (idx == (s.length() - 1) && p_idx == (p.length() - 1)
								&& s.charAt(idx)==p.charAt(p_idx)) {
							return true;
						}
					}
				} else if (compareChar == '.') {
					p_idx++;
				} else if (compareChar == s.charAt(idx)) {
					p_idx++;
				} else {
					if(p_idx<p.length()-1) {
						if(p.charAt(p_idx+1) == '*') {
							idx--;
							p_idx++;
						}else {
							return false;
						}
					}else {
						return false;
					}
				}
				System.out.println(p_idx + "=" + (p.length()));
				System.out.println(idx + "=" + (s.length() - 1));
				if (idx == (s.length() - 1)) {
					
					while(p_idx<p.length()) {
						if(p.charAt(p_idx) !='*') {
							return false;
						}
						p_idx++;
					}
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
