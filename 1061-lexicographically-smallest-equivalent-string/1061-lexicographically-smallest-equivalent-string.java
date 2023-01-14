class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        HashMap<Character, HashMap<Character, Boolean>> m = new HashMap<>();

        HashMap<Character, Boolean> curMap = new HashMap();
        Character saveKey;
        Boolean chkYn = false;
        for(int cIdx = 0; cIdx<s1.length(); cIdx++){
            
            Character c1 =s1.charAt(cIdx);
            Character c2 =s2.charAt(cIdx);
                    
            chkYn = false;
            List<Character> keyList = new ArrayList<>(m.keySet());
            keyList.sort((char1, char2) -> char1.compareTo(char2));
            for(Character key : keyList){ //저장된 key값 확인
                curMap = m.get(key);
                if(curMap.containsKey(c1)&&curMap.containsKey(c2)){
                        chkYn =true;
                        break;
                    }else if(curMap.containsKey(c1)){
                        chkYn = addCharacter(m,key,c2);
                        break;
                    }
                    else if(curMap.containsKey(c2)){
                        chkYn = addCharacter(m,key,c1);
                        break;
                    }
                
            }
            if(!chkYn){
                curMap = new HashMap();
                saveKey = s1.charAt(cIdx)<s2.charAt(cIdx)?s1.charAt(cIdx):s2.charAt(cIdx);
                curMap.put(s1.charAt(cIdx),true);
                curMap.put(s2.charAt(cIdx),true);
                m.put(saveKey,curMap);
            }
        }
        String result="";
        
        for(int cIdx = 0; cIdx<baseStr.length(); cIdx++){
            chkYn = false;
            List<Character> keyList = new ArrayList<>(m.keySet());
            keyList.sort((char1, char2) -> char1.compareTo(char2));
            for(char key : keyList){ //저장된 key값 확인
                curMap = m.get(key);
                if(curMap.containsKey(baseStr.charAt(cIdx))){
                        result+=key;
                        chkYn = true;
                        break;
                }
            }
            if(!chkYn){
                result+=baseStr.charAt(cIdx);
            }
        }
        return result;
    }
    public static boolean addCharacter(HashMap<Character, HashMap<Character, Boolean>> m,Character key,Character input){
        
        HashMap<Character, Boolean> curMap = m.get(key);
        curMap.put(input,true);

        for(Character tempK : m.keySet()){ //저장된 key값 확인
            if(tempK !=key ) {
                HashMap<Character, Boolean> temp = m.get(tempK);
                if(temp.containsKey(input)){
                    curMap.putAll(temp);
                }
            }
        }
        Character saveKey = input<key?input:key;
        m.remove(key);
        m.put(saveKey,curMap);
        return true;
    }
}