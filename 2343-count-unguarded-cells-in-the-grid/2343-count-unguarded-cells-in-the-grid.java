class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls){  
        int[][] map = new int[m][n];
        setWall(map,walls);
        setGuard(map,guards);
        for(int g=0; g<guards.length; g++){
            setGuardArea(map,guards[g][0],guards[g][1]);
        }
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
    public void setGuardArea(int[][] map, int row, int col){
        int r = row-1;
        while(r>=0 && r<map.length && map[r][col]<2){
            map[r][col]=1;
            r--;
        }
        r = row+1;
        while(r>=0 && r<map.length&& map[r][col]<2){
            map[r][col]=1;
            r++;
        }
        int c=col-1;
        while(c>=0 && c<map[0].length&& map[row][c]<2){
            map[row][c]=1;
            c--;
        }
        c=col+1;
        while(c>=0 && c<map[0].length && map[row][c]<2){
            map[row][c]=1;
            c++;
        }
    }
}