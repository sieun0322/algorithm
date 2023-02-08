class Solution {
    public int totalFruit(int[] fruits) {
        int result = 1;
        int temp = 1;
        for(int i = 0; i<fruits.length-1; i++){
            int pair1 = fruits[i];
            int pair2 = fruits[i+1];
            
            if(pair1==pair2){
                temp++;
            }else{
                for(int j = i+1; j<fruits.length; j++){
                    if(fruits[j] == pair1|| fruits[j] == pair2) {
                         temp++;
                     }else{
                         break;
                     }
                }
                result = result > temp ? result: temp;
                
                temp = 1;
            }
        }
        return result > temp ? result: temp;
    }
}