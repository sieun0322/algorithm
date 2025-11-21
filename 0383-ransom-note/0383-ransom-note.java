class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] list = new int['a'-'A'];
        int maxLength = Math.max(ransomNote.length(), magazine.length());
        for(int i = 0; i<maxLength; i++){
            if(i<ransomNote.length()){
                list[ransomNote.charAt(i)-'a']-=1;
            }
            if(i<magazine.length()){
                list[magazine.charAt(i)-'a']+=1;
            }
        }
        for(int i = 0; i<list.length; i++){
            if(list[i]<0){
                return false;
            }
        }
        return true;
    }
}