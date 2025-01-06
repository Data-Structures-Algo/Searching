class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = getMax(nums);
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canDivide(nums, mid, threshold)) {
                result = mid;
                high = mid - 1; // Try smaller divisor
            } else {
                low = mid + 1; // Try larger divisor
            }
        }

        return result;
    }

    private int getMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    private boolean canDivide(int[] nums, int divisor, int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor; // Equivalent to Math.ceil(num / divisor)
            if (sum > threshold) {
                return false;
            }
        }
        return true;
    }
}
