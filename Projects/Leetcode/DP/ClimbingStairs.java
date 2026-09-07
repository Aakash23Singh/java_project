// LeetCode 70 - Climbing Stairs
// https://leetcode.com/problems/climbing-stairs/

/*
QUESTION:

You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps.

Find the number of distinct ways to reach the top.

Example:
Input: n = 3
Output: 3

Ways:
1. 1 + 1 + 1
2. 1 + 2
3. 2 + 1
*/

/*
EXPLANATION:

To reach step n, we can come from:
1. Step n-1 by taking 1 step.
2. Step n-2 by taking 2 steps.

Therefore:

ways(n) = ways(n-1) + ways(n-2)

This is similar to the Fibonacci sequence.
The problem can be solved using recursion and dynamic programming.
*/


// ============================================================
// APPROACH 1: RECURSION
// ============================================================

/*
Idea:
Try both possibilities: take 1 step or take 2 steps.

Time Complexity: O(2^n)
Space Complexity: O(n)
*/

class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}


// ============================================================
// APPROACH 2: MEMOIZATION
// ============================================================

/*
Idea:
Recursion calculates the same values many times.
Store already calculated results in an array.

Time Complexity: O(n)
Space Complexity: O(n)
*/

// class Solution {
//     public int climbStairs(int n) {
//         int[] dp = new int[n + 1];
//         return solve(n, dp);
//     }
//     private int solve(int n, int[] dp) {
//         if (n == 0 || n == 1) {
//             return 1;
//         }
//         if (dp[n] != 0) {
//             return dp[n];
//         }
//         dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
//         return dp[n];
//     }
// }


// ============================================================
// APPROACH 3: TABULATION
// ============================================================

/*
Idea:
Calculate the answer from the bottom using a DP array.

dp[i] = dp[i-1] + dp[i-2]

Time Complexity: O(n)
Space Complexity: O(n)
*/

// class Solution {
//     public int climbStairs(int n) {
//         if (n <= 2) {
//             return n;
//         }
//         int[] dp = new int[n + 1];
//         dp[1] = 1;
//         dp[2] = 2;
//         for (int i = 3; i <= n; i++) {
//             dp[i] = dp[i - 1] + dp[i - 2];
//         }
//         return dp[n];
//     }
// }


// ============================================================
// APPROACH 4: SPACE OPTIMIZED DP
// ============================================================

/*
Idea:
We only need the previous two values.
So, instead of using a complete DP array, we store only two values.

Time Complexity: O(n)
Space Complexity: O(1)
*/

// class Solution {
//     public int climbStairs(int n) {
//         if (n <= 2) {
//             return n;
//         }
//         int prev2 = 1;
//         int prev1 = 2;
//         for (int i = 3; i <= n; i++) {
//             int current = prev1 + prev2;
//             prev2 = prev1;
//             prev1 = current;
//         }
//         return prev1;
//     }
// }