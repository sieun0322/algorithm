package algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author zion
 * Runtime: 81 ms, faster than 5.03% of Java online submissions for First Bad Version.
 * Memory Usage: 40.8 MB, less than 49.89% of Java online submissions for First Bad Version.
 */
public class FirstBadVersion_278 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1;
		
		int left = 1;
        int right = n;
        int mid = 1;
        int result = 1;
        boolean isBad;
        while(left<right){
            if(!isBadVersion(left) && isBadVersion(left+1)){
                result = left+1;
                break;
            }
            mid = left + (right-left)/2;
            isBad = isBadVersion(mid);
            if(isBad){
                right = mid;
            }else{
                left = mid;
            }
        }
		System.out.println("result:"+result);				
	}
	public static boolean isBadVersion(int n) {
        int bad = 1;
        
        return n<bad ? false : true;
    }
}
