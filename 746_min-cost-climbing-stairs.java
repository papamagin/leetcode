//https://leetcode.com/problems/min-cost-climbing-stairs/description/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int two = cost[n - 1], one = cost[n - 2];
        for (int i = n - 3; i >= 0; i--) {
            int temp = one;
            one = cost[i] + Math.min(one, two);
            two = temp;
        }
        return Math.min(one, two);
    }
}
