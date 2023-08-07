class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length-1;
        while(start<end){
            int mid = (start+end)/2;
            if(target == matrix[mid][0]){
                return true;
            }else if(target<matrix[mid][0]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        int row = target<matrix[start][0]? start-1: start;
        if(row>=0){
            return binary(matrix[row], target, 0, matrix[row].length-1);
        }
        return false;
    }
    public static boolean binary(int[] rowMatrix, int target, int start, int end){
        if(start<=end){
            int mid = (start+end)/2;
            if(target==rowMatrix[mid]){
                return true;
            }
            else if(target<rowMatrix[mid]){
                return binary(rowMatrix,target,start, mid-1);
            }else{
                return binary(rowMatrix,target,mid+1, end);
            }
        }
        return false;
    }
}