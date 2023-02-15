class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int size = 1;
        int x = 0;
        List<Integer> result = new LinkedList();
        int i = num.length-1;
        while(i>=0 ||k>0 ){
            int sum = x;
            if(i>=0){
                sum+=num[i];
            }
            if(k>0){
                sum+=k%10;
            }
            result.add(0,sum%10);
            x = sum/10;
            k = k/10;
            i--;
        }
        if(x!=0){
            result.add(0,x);
        }
        return result;
    }
}