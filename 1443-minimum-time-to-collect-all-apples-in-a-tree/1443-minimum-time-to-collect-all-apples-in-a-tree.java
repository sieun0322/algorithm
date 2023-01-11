class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        List<Integer>[] list = new ArrayList[n];
        boolean[] visited = new boolean[n];
  
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<Integer>();
            visited[i] = false;
        }
        for(int i = 0; i<edges.length; i++){
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }
        visited[0]=true;
        for(int i = 0; i<list[0].size(); i++){
            if(!visited[list[0].get(i)]){
                result +=search(list[0].get(i), list, hasApple, visited);
            }
        }
        return result;
    }
    public int search(int target, List<Integer>[] e, List<Boolean> h, boolean[] v) {
        
        v[target] = true;
        
        int tempCnt = 0;
        boolean appleYn =false;
        
        for(int i = 0; i<e[target].size(); i++){
            
            if(!v[e[target].get(i)]){
                tempCnt +=search(e[target].get(i), e, h, v);
            }
            if(tempCnt>0) appleYn = true;
        }
        
        if(appleYn){
            return tempCnt+2;
        }else {
            if(h.get(target)){
                return 2;
            }else{
                return 0;
            }
        }
        
    }
}