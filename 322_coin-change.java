//https://leetcode.com/problems/coin-change/description/

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                int diff = i - coins[j];
                if (diff < 0) {
                    break;
                }
                if (dp[diff] < Integer.MAX_VALUE && dp[diff] + 1 < dp[i]) {
                    dp[i] = dp[diff] + 1;
                }
            }
        }
        return dp[amount] < Integer.MAX_VALUE ? dp[amount] : -1;
    }
}
