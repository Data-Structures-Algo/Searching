class Solution {
    public boolean search(int[] nums, int target) {
        // smallest element
        int minindex = findmin(nums);

        // the left half (from 0 to minindex - 1)
        boolean ans = binarysearch(nums, 0, minindex - 1, target);

        if (!ans) { // If not found in the left half
            ans = binarysearch(nums, minindex, nums.length - 1, target);
        }

        return ans;
    }

    private int findmin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1; // Search in the right half
            } else if (nums[mid] < nums[right]) {
                right = mid; // Search in the left half
            } else {
                 // When nums[mid] == nums[right], shrink the range but carefully
                if (nums[right - 1] > nums[right]) {
                    left = right; // Pivot found
                } else {
                    right--;
                }     // Skip duplicates
            }
        }

        return left; // Index of the smallest element
    }

    private boolean binarysearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true; 
            }

            if (nums[mid] < target) {
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
