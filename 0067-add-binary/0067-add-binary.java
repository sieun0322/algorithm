class Solution {
    public String addBinary(String a, String b) {
        String result ="";
        int idx = 0;
        int x = 0;
        while(idx<a.length()||idx<b.length()){
            int intA = idx<a.length()? a.charAt(a.length()-idx-1)-'0':0;
            int intB = idx<b.length()? b.charAt(b.length()-idx-1)-'0':0;
            int sum=intA+intB+x;
            x = sum>=2?1:0;
            result = (sum)%2+result;
            idx++;
        }
        if(x!=0) return x+result;
        return result;
    }
}