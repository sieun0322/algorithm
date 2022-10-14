class Solution {
    public int longestPalindrome(String s) {
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        
        int result = 0;
        boolean isEven = true;
        boolean isOddCnt =false;
        
        int i = 0;
        char target =charArr[0];
        while(i<charArr.length){
            if(target != charArr[i]){
              if(!isEven) isOddCnt = true;
              target = charArr[i];
              isEven = true;
            }
            isEven=!isEven;
            if(isEven) result+=2;
            i++;
        }
        if(!isEven) isOddCnt = true;
        return isOddCnt? result+1: result;
    }
}