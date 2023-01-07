class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sArr = s.split(" ");
        if(pattern.length() != sArr.length) return false;
        for(int i = 0; i<pattern.length(); i++){
            char c = pattern.charAt(i);
            String word = sArr[i];
            int cnt = 0;
            for(int j = i+1; j<pattern.length(); j++){
                
                if(c == pattern.charAt(j)){
                    if(!word.equals(sArr[j])) return false;
                }else{
                    if(word.equals(sArr[j])) return false;
                }
            }
        }
        return true;
    }
}