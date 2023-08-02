class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int cnt = 1;
        for(int i = 1; i<nums.length+1; i++){
            cnt*=i;
        }
        bfs(result,new ArrayList<Integer>(), nums,cnt);
        
        return result;
    }
    public static void bfs(List<List<Integer>> result, List<Integer> cur, int[] nums, int cnt){
        if(cur.size() == nums.length){
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for(int i = 0; i<nums.length; i++){
            if(cur.indexOf(nums[i])==-1){
                cur.add(nums[i]);
                bfs(result,cur, nums,cnt);
                cur.remove(cur.size()-1);
                if(cnt == result.size()){
                    return;
                }
            }
        }
    }
}