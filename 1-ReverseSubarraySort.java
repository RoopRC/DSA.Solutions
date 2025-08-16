/*
Check if reversing a sub array make the array sorted
Last Updated : 13 Sep, 2023
Given an array of n distinct integers. The task is to check whether reversing any one sub-array can make the array sorted or not. If the array is already sorted or can be made sorted by reversing any one subarray, print "Yes", else print "No".

Examples: 



Input : arr [] = {1, 2, 5, 4, 3}
Output : Yes
By reversing the subarray {5, 4, 3}, the array will be sorted.





Input : arr [] = { 1, 2, 4, 5, 3 }
Output : No
  */
public class ReverseSubarraySort {

    static boolean canBeSorted(int[] arr) {
        int n = arr.length;

        // Step 1: Find the first index where order breaks
        int l = 0;
        while (l < n - 1 && arr[l] < arr[l + 1]) {
            l++;
        }

        // If array is already sorted
        if (l == n - 1) {
            return true;
        }

        // Step 2: Find the last index where order breaks
        int r = n - 1;
        while (r > 0 && arr[r] > arr[r - 1]) {
            r--;
        }

        // Step 3: Reverse subarray arr[l..r]
        reverse(arr, l, r);

        // Step 4: Check if array is sorted after reversal
        boolean sorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                sorted = false;
                break;
            }
        }

        // Restore original array if needed (optional)
        reverse(arr, l, r);

        return sorted;
    }

    // Helper function to reverse part of the array
    static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 5, 4, 3};
        System.out.println(canBeSorted(arr1) ? "Yes" : "No"); // Output: Yes

        int[] arr2 = {1, 2, 4, 5, 3};
        System.out.println(canBeSorted(arr2) ? "Yes" : "No"); // Output: No

        int[] arr3 = {1, 2, 3, 4, 5};
        System.out.println(canBeSorted(arr3) ? "Yes" : "No"); // Output: Yes
    }
}
