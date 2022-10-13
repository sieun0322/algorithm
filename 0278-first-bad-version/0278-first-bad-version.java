/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return searchVsersion(1, n);
    }
    public int searchVsersion(int start, int end){
        if(end<start) return 0;
        
        int mid = start+(end-start)/2;
        int result = 0;
        
        if(isBadVersion(mid)){
            if(!isBadVersion(mid-1)) return mid;
            return searchVsersion(start,mid-1);
        }else{
            if(isBadVersion(mid+1)) return mid+1;
            return searchVsersion(mid+1,end);
        }
    }
}