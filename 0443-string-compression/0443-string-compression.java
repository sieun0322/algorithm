class Solution {
    public int compress(char[] chars) {
    int nLength = 0;
    int length = 1;
    for(int i = 1; i<chars.length; i++){
        if(chars[i-1] != chars[i]){
            chars[nLength++] = chars[i-1];
            if(length > 1){
                int size=Integer.toString(length).length();
                for(int s = 1; s<=size; s++){
                    chars[nLength+size-s] = (char)((length%10)+48);
                    length /=10;
                }
                nLength += size;
            }
            length = 1;
            if(i == (chars.length-1)){
                chars[nLength]  = chars[i];
            }
        }else if(chars[i-1] == chars[i]){
            length += 1;
            if(i == (chars.length-1)){
                chars[nLength++]  = chars[i];
                if(length > 1){
                    int size=Integer.toString(length).length();
                    for(int s = 1;s<=size; s++){
                        chars[nLength+size-s] = (char)((length%10)+48);
                        length /=10;
                    }
                    nLength += size-1;
                }
            }
        }
    }
        return nLength+1;
    }
        
}