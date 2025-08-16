/*
Make all array elements equal with minimum cost
Last Updated : 22 Apr, 2025
Given an array of size n, the task is to make the value of all elements equal with minimum cost. The cost of changing a value from x to y is abs(x - y).

Examples : 

Input: arr[] = [1, 100, 101]
Output: 100
Explanation: We can change all its values to 100 with minimum cost,
|1 - 100| + |100 - 100| + |101 - 100| = 100

Input: arr[] = [4, 6]
Output: 2
Explanation: We can change all its values to 5 with minimum cost,
|4 - 5| + |5 - 6| = 2

Input: arr[] = [5, 5, 5, 5]
Output: 0
Explanation: All the values are already equal.
  */
import java.util.*;

public class MinCostEqualElements {

    // Function to calculate minimum cost
    static int minCost(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        // Find median
        int median = arr[n / 2];

        int cost = 0;
        for (int num : arr) {
            cost += Math.abs(num - median);
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 100, 101};
        System.out.println(minCost(arr1)); // Output: 100

        int[] arr2 = {4, 6};
        System.out.println(minCost(arr2)); // Output: 2

        int[] arr3 = {5, 5, 5, 5};
        System.out.println(minCost(arr3)); // Output: 0
    }
}
