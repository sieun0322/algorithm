class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long result = 0;
        long begin = 1;
        long end = (long)time[time.length-1]*totalTrips;
        while(begin<end){
            long mid = begin+(end - begin)/2;
            long midNum = numTrips(time,mid);
            if(totalTrips<=midNum){
                end = mid;
            }else if(totalTrips>midNum){
                begin = mid+1;
            }
        }
        return begin;
    }
    public static long numTrips(int[] time, long atTime){
        long result = 0;
        for(int i=0; i<time.length; i++){
            result +=atTime/time[i];
        }
        return result;
    }
}