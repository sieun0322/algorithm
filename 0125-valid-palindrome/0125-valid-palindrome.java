class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int sIdx = 0;
        int eIdx = s.length()-1;
        while(sIdx<eIdx){
            char sChar = s.charAt(sIdx);
            char eChar = s.charAt(eIdx);
            while(sIdx<s.length() && !isAlphanumeric(s.charAt(sIdx))){
                sIdx+=1;
            }
            while(eIdx>=0 && !isAlphanumeric(s.charAt(eIdx))){
                eIdx-=1;
            }
            if(sIdx<eIdx){
                if(s.charAt(sIdx)!=s.charAt(eIdx)){
                    return false;
                }
            }
            sIdx++;
            eIdx--;
        }
        return true;
    }
    public boolean isAlphanumeric(char c) {
        if(('a' > c || c >'z') && ('0' > c || c >'9')){
            return false;
        }
        return true;
    }
}