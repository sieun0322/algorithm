class Solution {
    int result = 0;
    public int longestPath(int[] parent, String s) {
        List<Integer>[] list = new ArrayList[parent.length];
        boolean[] visit = new boolean[parent.length];
        for(int i = 0; i<list.length; i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i<parent.length; i++){
            if(parent[i] != -1 && s.charAt(i) != s.charAt(parent[i])){
                list[i].add(parent[i]);
                list[parent[i]].add(i);
            }
        }
        for(int i = 0; i<parent.length; i++){
           search(i,list, visit);
        }
        return result;
    }
    public int search(int target, List<Integer>[] lst, boolean[] visited) {
        visited[target] = true;
        int max1 = 0;
        int max2 = 0;
        for(int i = 0; i<lst[target].size(); i++){
            if(!visited[lst[target].get(i)]){
                int temp = search(lst[target].get(i), lst, visited);
                if(temp>max1){
                    max2 = max1;
                    max1 = temp;
                }else{
                    max2 = temp>max2?temp:max2;
                }
            }
        }
        result = result>max1+max2+1?result:max1+max2+1;
        return max1+1;
    }
        
}