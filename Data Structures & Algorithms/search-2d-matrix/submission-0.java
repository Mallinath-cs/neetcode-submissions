class Solution {
     public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = searchPotentialRow(matrix, target);
        if(rowIndex != -1) return binarySearchOverRow(rowIndex, matrix, target);
        return false;
    }
    public int searchPotentialRow(int[][] matrix, int target){
        int low = 0;
        int high = matrix.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length - 1]){
                return mid;
            }
            else if(matrix[mid][0] < target) low = mid + 1;
            else if(matrix[mid][0] > target) high = mid - 1;
        }
        return -1;
    }
    public boolean binarySearchOverRow(int rowIndex, int[][] matrix, int target){
        int low = 0;
        int high = matrix[rowIndex].length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(matrix[rowIndex][mid] == target){
                return true;
            }
            else if(target < matrix[rowIndex][mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }
}
