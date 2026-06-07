class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        if(pivot == -1){
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        if(target == nums[pivot]){
            return pivot;
        }
        if(target >= nums[0]){
            return binarySearch(nums, target, 0, pivot -1);
        }
        return binarySearch(nums, target, pivot + 1, nums.length -1);
    }
    public int binarySearch(int[] nums, int target, int left, int right){
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(target == nums[mid]){
                return mid;
            }
            else if(target > nums[mid]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
    public int findPivot(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(mid < right && nums[mid] > nums[mid + 1]){
                return mid;
            }
            else if( mid > left && nums[mid] < nums[mid - 1]){
                return mid - 1;
            }
            else if(nums[mid] <= nums[left] ){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
