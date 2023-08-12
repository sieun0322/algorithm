class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        for(int x = 0; x<obstacleGrid.length; x++){
            for(int y = 0; y<obstacleGrid[0].length; y++){
                if(obstacleGrid[x][y]==1){
                    obstacleGrid[x][y]=0;
                }else{
                    if(x==0 && y==0){
                        obstacleGrid[x][y]=1;
                    }
                    if(x>0){
                        obstacleGrid[x][y]+=obstacleGrid[x-1][y];
                    }
                    if(y>0){
                        obstacleGrid[x][y]+=obstacleGrid[x][y-1];
                    }
                }
            }
        }
        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}