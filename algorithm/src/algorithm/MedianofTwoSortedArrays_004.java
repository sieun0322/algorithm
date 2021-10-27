package algorithm;

public class MedianofTwoSortedArrays_004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n1 = {2};
		int[] n2= {};
		
		System.out.println(findMedianSortedArrays(n1,n2));
	}
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length+nums2.length;
        int medianIdx;
        boolean even;
        if(size%2 == 1) {
        	medianIdx = (size-1)/2;
        	even = true;
        }else {
        	medianIdx = size/2-1;
        	even = false;
        }
        int idx1 =0;
        int idx2 = 0;
        int median1 = 0;
        for(int i = 0; i<=medianIdx; i++) {
            if(idx1 >=nums1.length) {nums1 = new int[]{987654321};idx1=0;};
            if(idx2 >=nums2.length) {nums2 = new int[]{987654321};idx2=0;};
        	if(nums1[idx1]<nums2[idx2]) {
        		median1=nums1[idx1];
        		idx1++;
        	}else {
        		median1=nums2[idx2];
        		idx2++;
        	}   
        }
        if(even) {
        		return median1;
        }else {
        	int median2 = 0;
        	if(idx1 >=nums1.length) {nums1 = new int[]{987654321};idx1=0;};
            if(idx2 >=nums2.length) {nums2 = new int[]{987654321};idx2=0;};
        	if(nums1[idx1]<nums2[idx2]) {
        		median2 = nums1[idx1];
        	}else {
        		median2 = nums2[idx2];
        	}
            return (median1+median2)/2.0;
        }
    }
/*
 * Runtime: 2 ms, faster than 99.91% of Java online submissions for Median of Two Sorted Arrays.
Memory Usage: 40.3 MB, less than 61.40% of Java online submissions for Median of Two Sorted Arrays.
 */
}

