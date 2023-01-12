class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<Integer>[] list = new ArrayList[n];
        int[] result = new int[n];
        
        for(int i = 0; i<n; i++){
            list[i] = new ArrayList<Integer>();
            result[i] = -1;
            
        }
        for(int i = 0; i<edges.length; i++){
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }
        
        
        int[] alphaCnt = search(0,list, result,labels);
        return result;
        
    }
    public int[] search(int target, List<Integer>[] lst,int[] v, String lbl) {
        int[] cnt = new int[26];
        for(int i=0; i<cnt.length; i++){
            cnt[i]=0;
        }
        v[target] = 0;
        for(int i = 0; i<lst[target].size(); i++){
            if(v[lst[target].get(i)] == -1){
                int[] temp = search(lst[target].get(i),lst,v,lbl);
                for(int k = 0; k<cnt.length; k++){
                    cnt[k]+=temp[k];
                }
            }
        }
        cnt[lbl.charAt(target)-'a'] +=1;
        v[target] = cnt[lbl.charAt(target)-'a'];
        return cnt;
        
    }
    
}