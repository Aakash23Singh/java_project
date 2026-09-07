/*

746. Min Cost Climbing Stairs
https://leetcode.com/problems/min-cost-climbing-stairs/description/


You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
Once you pay the cost, you can either climb one or two steps.
You can either start from the step with index 0, or the step with index 1.
Return the minimum cost to reach the top of the staircase, which is the position just past the last step (index cost.length).

Example 1:
Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6. */

import java.util.Arrays;
class Solution {
    // =====================================================
    // 1. RECURSION
    // =====================================================
    public int recursion(int[] cost, int i) {
        if(i == 0)
            return cost[0];
        if(i == 1)
            return cost[1];
        return cost[i] + Math.min(
                recursion(cost, i - 1),
                recursion(cost, i - 2)
        );
    }

    // =====================================================
    // 2. MEMOIZATION
    // =====================================================
    public int memoization(int[] cost, int i, int[] dp) {
        if(i == 0)
            return cost[0];
        if(i == 1)
            return cost[1];
        if(dp[i] != -1)
            return dp[i];
        return dp[i] = cost[i] + Math.min(
                memoization(cost, i - 1, dp),
                memoization(cost, i - 2, dp)
        );
    }

    // =====================================================
    // 3. TABULATION
    // =====================================================
    public int tabulation(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(
                    dp[i - 1],
                    dp[i - 2]
            );
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    // =====================================================
    // 4. SPACE OPTIMIZATION
    // Time : O(n)
    // Space: O(1)
    // =====================================================
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev2 = cost[0];
        int prev1 = cost[1];
        for(int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(
                    prev1,
                    prev2
            );
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.min(prev1, prev2);
    }
}