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
                temp = maxCnt(fruits,i+1,temp);
                result = result > temp ? result: temp;
                
                temp = 1;
            }
        }
        return result > temp ? result: temp;
    }
    public int maxCnt(int[] f, int idx, int tempCnt){
        int result = 1; 
        int temp = tempCnt;
        for(int j = idx; j<f.length; j++){
         if(f[j] == f[idx-1] || f[j] == f[idx]) {
             temp++;
         }else{
             break;
         }
        }
        return result > temp? result:temp;
    }
}