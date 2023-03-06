class Solution {
    public int findKthPositive(int[] arr, int k) {
        int cur = 1;
        int i = 0;
        while(k>0){
            while(i<arr.length && cur == arr[i]){
                i++;
                cur++;
            }
            cur++;
            k--;
        }
        return cur-1;
    }
}