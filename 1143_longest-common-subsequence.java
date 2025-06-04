//https://leetcode.com/problems/longest-common-subsequence/description/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = n - 1; i > -1; i--) {
            for (int j = m - 1; j > -1; j--) {
                dp[i][j] = text1.charAt(i) == text2.charAt(j) ? 
                           dp[i + 1][j + 1] + 1
                           : Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }
}

// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         Map<String, Integer> memo = new HashMap<>();
//         int l1 = text1.length();
//         int l2 = text2.length();
//         longest(l1, l2, text1, text2, memo);
//         String memoKey = strKey(l1, l2);
//         return memo.keySet().contains(memoKey) ? memo.get(memoKey) : 0;
//     }
//     private int longest(int i, int j, String text1, String text2, Map<String, Integer> memo) {
//         if (i <= 0 || j <= 0) {
//             return 0;
//         }
//         String memoKeyIJ = strKey(i, j);
//         if (memo.keySet().contains(memoKeyIJ)) {
//             return memo.get(memoKeyIJ);
//         }
//         int res = 0;
//         if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
//             res = 1 + longest(i - 1, j - 1, text1, text2, memo);
//         } else {
//             res = Math.max(longest(i - 1, j, text1, text2, memo), longest(i, j - 1, text1, text2, memo));
//         }
//         memo.put(memoKeyIJ, res);
//         return res;
//     }
//     private String strKey(int i, int j) {
//         return String.valueOf(i) + "," + String.valueOf(j);
//     }
// }
