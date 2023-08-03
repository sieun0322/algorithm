class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits.length() !=0){
            dfs(result,digits,0);
        }
        return result;
    }
    public static void dfs(List<String> list, String digits, int index){
        if(index == digits.length()){
            list.add(new String(digits));
            return;
        }
        int target = digits.charAt(index);
        int start = toChar(target,true);
        int end = toChar(target,false);
        for(int i=start; i<end+1; i++){
            dfs(list, digits.substring(0,index)+(char)i+digits.substring(index+1), index+1);
        }
    }
    public static int toChar(int target,boolean isStart){
        switch(target){
            case '2':
                return isStart?'a':'c';
            case '3':
                return isStart?'d':'f';
            case '4':
                return isStart?'g':'i';
            case '5':
                return isStart?'j':'l';
            case '6':
                return isStart?'m':'o';
            case '7':
                return isStart?'p':'s';
            case '8':
                return isStart?'t':'v';
            case '9':
                return isStart?'w':'z';
                    
        }
        return 0;
    }
}