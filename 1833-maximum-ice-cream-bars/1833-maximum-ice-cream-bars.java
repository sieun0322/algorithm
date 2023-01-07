class Solution {
    public int maxIceCream(int[] costs, int coins) {
        //
        int result = 0;
        Arrays.sort(costs);
        for(int cost:costs){
            if(cost>coins) break;
            coins-=cost;
            result++;
        }
        return result;
    }
}