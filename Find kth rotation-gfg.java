class Solution {
    public int findKRotation(List<Integer> arr) {
        int n = arr.size();
        int low = 0;
        int high = n - 1;
        
        // If the array is already sorted, the rotation count is 0
        if (arr.get(0) <= arr.get(n - 1)) {
            return 0;
        }

        // Binary search for the pivot (smallest element)
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is the pivot
            if (arr.get(mid) < arr.get((mid - 1 + n) % n) && 
                arr.get(mid) <= arr.get((mid + 1) % n)) {
                return mid;
            }

            // Decide whether to go to the left or right half
            if (arr.get(mid) >= arr.get(0)) {
                low = mid + 1; // Pivot must be in the right half
            } else {
                high = mid - 1; // Pivot must be in the left half
            }
        }
        
        return 0; // Default case (shouldn't reach here for valid input)
    }
}
