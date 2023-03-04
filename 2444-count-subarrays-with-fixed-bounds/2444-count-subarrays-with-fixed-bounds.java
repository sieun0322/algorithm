class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int i = 0;
        int fS = -1;
        int fE = -1;
        int pre = -1;
        long result = 0L;
        while(i<nums.length){
            if(minK==nums[i]){
                fS = i;
            }
            if(maxK==nums[i]){
                fE = i;
            }
            if(fS != -1 && fE != -1){
                int Bs = fS<fE? fS:fE;
                
                int cntB = Bs - pre -1;
                int cntA = 0;
                int sL = i+1;
                while(sL < nums.length && minK<=nums[sL] && maxK>=nums[sL]){
                    cntA++;
                    sL++;
                }
                result += (cntB+1) * (cntA+1);
                if(minK == maxK){
                    for(int idx = 1; idx < cntA+1; idx++ ){
                        result += idx;
                    }
                    pre = sL;
                    i = sL;
                    fS = -1;
                    fE = -1;
                }else{
                    pre = Bs;
                    if(Bs == fS){
                        fS = -1;
                    }else if(Bs == fE){
                        fE = -1;
                    }
                }
            }else if(minK>nums[i] || maxK<nums[i]){
                fS = -1;
                fE = -1;
                pre = i;
            }
            i++;
        }
        return result;
        
    }
}