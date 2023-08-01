class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        bfs(result,new ArrayList<Integer>(),n,k);
        return result;
    }
    public static void bfs(List<List<Integer>> result,List<Integer> cur, int n, int k){
        if(cur.size() == k){
            result.add(new ArrayList<>(cur));
            return;
        }
        int nextNum = 1;
        if(!cur.isEmpty()){
            nextNum = cur.get(cur.size()-1)+1;
        }
        for(int i=nextNum; i<=n; i++){
            cur.add(i);
            bfs(result,cur,n,k);
            cur.remove(cur.size()-1);
        }
    }
}