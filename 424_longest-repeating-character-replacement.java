//https://leetcode.com/problems/longest-repeating-character-replacement/description/

class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if (k == n) {
            return n;
        }
        int res = 0;
        int[] counter = new int[26];
        int l = 0;
        int max = 0;
        for (int r = 0; r < n; r++) {
            char curr = s.charAt(r);
            max = Math.max(++counter[curr - 'A'], max);
            while (r - l + 1 - max > k) {
                counter[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(r - l + 1, res);
        }

        return res;
    }
}
