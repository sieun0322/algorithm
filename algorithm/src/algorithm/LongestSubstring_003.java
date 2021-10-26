package algorithm;

public class LongestSubstring_003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "au";
		System.out.println(lengthOfLongestSubstring(s));
	}
    public static int lengthOfLongestSubstring(String s) {
    	int result = 0;
    	int length = 0;
    	int index = 0;
        while(index<s.length()) {
        	length = 0;
        	int index_y = index+1;
        	while(index_y<s.length()) {
            	
	        	String str = s.substring(index,index_y);
	        	String s_char = s.substring(index_y,index_y+1);
	        	
	        	int find_idx = str.indexOf(s_char);
	        	if(find_idx >= 0) {
	        		length = str.length();
	        		if(length>result) {
		        		result = length;
		        	}
	        		break;
	        	}
	        	index_y++;
        	}
        	if(index_y == s.length()) {
        		length = s.length()-(index);
        	    break;
        	}
        	if(length>result) {
        		result = length;
        	}
        	index++;
        }
        if(length>result) {
    		result = length;
    	}
        return result;
    }
/*
 * Runtime: 208 ms, faster than 9.35% of Java online submissions for Longest Substring Without Repeating Characters.
Memory Usage: 39.9 MB, less than 50.39% of Java online submissions for Longest Substring Without Repeating Characters.
 */
}
