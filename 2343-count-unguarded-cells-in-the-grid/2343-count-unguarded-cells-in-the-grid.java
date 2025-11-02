class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls){  
        int[][] map = new int[m][n];
        setWall(map,walls);
        setGuard(map,guards);
        setGuardArea(map,guards);
        return getUnGuardsCnt(map);
    }
    public void setWall(int[][] map,int[][] walls){
        for(int n=0; n<walls.length; n++){
            map[walls[n][0]][walls[n][1]]= 2;
        }
    }
    public void setGuard(int[][] map,int[][] guards){
        for(int n=0; n<guards.length; n++){
            map[guards[n][0]][guards[n][1]]= 2;
        }
    }
    public int getUnGuardsCnt(int[][] map){
        int cnt = 0;
        for(int row=0; row<map.length; row++){
            for(int col=0; col<map[0].length; col++){
                if(map[row][col]== 0)cnt++;
             }
        }
        return cnt;
    }
    public void setGuardArea(int[][] map, int[][] guards){
        int m = map.length;
        int n = map[0].length;
        int[] directions = {-1, 0, 1, 0, -1};
        for (int[] guard : guards) {
            for (int dirIndex = 0; dirIndex < 4; dirIndex++) {
                int row = guard[0];
                int col = guard[1];
                int rowDelta = directions[dirIndex];
                int colDelta = directions[dirIndex + 1];
              
                while (row + rowDelta >= 0 && 
                       row + rowDelta < m && 
                       col + colDelta >= 0 && 
                       col + colDelta < n && 
                       map[row + rowDelta][col + colDelta] < 2) {
                  
                    row += rowDelta;
                    col += colDelta;
                    map[row][col] = 1;
                }
            }
        }
    }
}