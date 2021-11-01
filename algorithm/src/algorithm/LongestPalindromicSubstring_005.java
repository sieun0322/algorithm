package algorithm;

import java.util.Stack;
/**
 * 
 * @author zion
 * Runtime: 1752 ms, faster than 5.01% of Java online submissions for Longest Palindromic Substring.
 * Memory Usage: 39.4 MB, less than 68.48% of Java online submissions for Longest Palindromic Substring.
 *
 */
public class LongestPalindromicSubstring_005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = ""; //output: bab
		System.out.println(longestPalindrome(s));
	}
    public static String longestPalindrome(String s) {
    	String result = s.length()>0?s.substring(0,1):"";
    	for(int size = s.length(); size>1; size--) {
    		boolean even = size%2 == 0? true:false;
    		int centerIdx = even == true? size/2 :(size+1)/2;
    		for(int start = 0; start<=s.length()-size; start++) {

        		String str = s.substring(start,start+size);
        		String front_s = even==true? str.substring(0,centerIdx):str.substring(0,centerIdx-1);
        		String back_s =  str.substring(centerIdx);
        		
        		if(compareString(front_s,back_s)) {
        			return str;
        		}
    		}
    	}
		return result;
        
    }
    public static boolean compareString(String front, String back) {
    	for(int i = 0; i<front.length(); i++) {
    		int frontChar = front.charAt(i);
    		int backChar = back.charAt((front.length()-1)-i);
    		if(frontChar != backChar)return false;
    	}
    	return true;
    }
    
}
