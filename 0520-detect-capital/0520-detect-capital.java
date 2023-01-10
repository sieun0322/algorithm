class Solution {
    public boolean detectCapitalUse(String word) {
        char type = word.charAt(0)<'a'?'U':'L';
        for(int i = 1; i<word.length(); i++){
            char c = word.charAt(i);
            if(type == 'U' && c>'Z' && i==1) type='L';
            else if(type == 'U' && c>'Z') return false;
            else if(type == 'L' && c<'a') return false;
        }
        return true;
    }
}