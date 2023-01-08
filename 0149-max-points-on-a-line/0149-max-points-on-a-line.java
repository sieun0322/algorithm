class Solution {
    public int maxPoints(int[][] points) {
        double tempX = 0;
        double tempY = 0;
        
        int tempCnt = 0;
        int maxCnt = 1;
        
        for(int tIdx=0; tIdx<points.length-1; tIdx++){
            
            for(int cIdx=tIdx+1; cIdx<points.length; cIdx++){
                tempCnt = 2;
                
                if(points[cIdx][0]==points[tIdx][0]){
                    //갯수Count
                    for(int i=cIdx+1; i<points.length; i++){
                        if(points[i][0] == points[cIdx][0]){
                            tempCnt++;
                        }
                    }
                }else if(points[cIdx][1]==points[tIdx][1]){
                    //갯수Count
                    for(int i=cIdx+1; i<points.length; i++){
                        if(points[i][1] == points[cIdx][1]){
                            tempCnt++;
                        }
                    }
                }else{
                    tempX = points[cIdx][0]-points[tIdx][0];
                    tempY = points[cIdx][1]-points[tIdx][1];
                    
                    //갯수Count
                    for(int i=cIdx+1; i<points.length; i++){
                        if((points[cIdx][1] - points[i][1])*tempX
                            ==((tempY*points[cIdx][0]) - (tempY*points[i][0]))){
                            tempCnt++;
                        }
                    }
                }
                //최대값
                if(tempCnt>maxCnt){
                    maxCnt = tempCnt;
                }
            }
        }
        return maxCnt;
    }
}