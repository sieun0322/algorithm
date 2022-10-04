package algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author zion
 * Runtime: 52 ms, faster than 10.20% of Java online submissions for Isomorphic Strings.
 * Memory Usage: 47.2 MB, less than 9.98% of Java online submissions for Isomorphic Strings.
 */
public class IsomorphicStrings_205 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "egg";
		String t = "add";
		boolean result = isIsomorphic(s, t);
		System.out.print("result = "+ result);      				
	}
	public static boolean isIsomorphic(String s, String t) {
        char[] replaceAlpha = new char[s.length()];

        if(s.length() != t.length()) return false;
        
        for(int index = 0; index<s.length(); index++){
            //변경전
            if(replaceAlpha[index] == 0 ){
            //1.비교값
            char fromChar = s.charAt(index);
            char toChar = t.charAt(index);

            //2.변경가능한 값일경우.
            if(new String(replaceAlpha).indexOf(toChar) == -1){
                //전체 검사.
                for(int replaceIndex = index; replaceIndex<s.length(); replaceIndex++){
                    //변경전
                    if(replaceAlpha[replaceIndex] == 0){
                        if(s.charAt(replaceIndex) == fromChar){
                            if(t.charAt(replaceIndex) == toChar){
                                replaceAlpha[replaceIndex] = toChar;
                            }else{
                                return false;
                            }
                        }
                        //역검사
                        if(t.charAt(replaceIndex) == toChar){
                            if(s.charAt(replaceIndex) != fromChar){
                                return false;
                            }
                        }
                    }
                    
                }
            }
            }
        }
        //최종결과 확인
        if(new String(replaceAlpha).equals(t)){
            return true;
        }else{
            return false;
        }

    }
}
