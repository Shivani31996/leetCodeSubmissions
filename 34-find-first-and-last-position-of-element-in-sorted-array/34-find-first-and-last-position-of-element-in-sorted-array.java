class Solution {
    public int[] searchRange(int[] nums, int target) {
                // Base Case
        if (nums.length == 0 || nums == null) return new int[]{-1, -1};

        if (target < nums[0] || target > nums[nums.length - 1]) return new int[]{-1,-1};

        int first = firstBinarySearch(nums, target);

        if (first == -1) {
            return new int[]{-1,-1};
        }

        int second = secondBinarySearch(nums, target);

        return new int[]{first, second};
    }

    public static int firstBinarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) { // Check if mid element is equal to target
                if (mid == 0 || nums[mid] > nums[mid-1]) {
                    return mid; // This condition validates where the target is greater than mid-1 (leftmost element of mid)
                    // or mid == 0, then first occurrence is found
                } else {
                    high = mid - 1;
                }
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int secondBinarySearch(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) { // Check if mid element is equal to target
                if (mid == nums.length - 1 || nums[mid] < nums[mid+1]) {
                    return mid; // This condition validates where the target is smaller than mid+1 (rightmost element of mid)
                    // or mid == last index of array, then last occurrence is found
                } else {
                    low = mid + 1;
                }
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;        
    }
}