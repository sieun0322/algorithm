class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int[] dx = new int[]{-1,0,0,1};
        int[] dy = new int[]{0,-1,1,0};
        int origin = image[sr][sc];
        Stack<int[]> stk = new Stack<>();
        stk.push(new int[]{sr,sc});
        while(stk.size()>0){
            int[] center = stk.pop();
            int cX = center[0];
            int cY = center[1];
            image[cX][cY] = color;
            visited[cX][cY] = true;
            for(int i=0; i<4; i++){
                int tX=cX+dx[i];
                int tY=cY+dy[i];
                if(0<=tX && tX<image.length && 0<=tY && tY<image[0].length){
                    if(image[tX][tY] == origin && visited[tX][tY] == false){
                        stk.push(new int[]{tX,tY});
                    }
                }
            }
        }
        return image;
    }
}