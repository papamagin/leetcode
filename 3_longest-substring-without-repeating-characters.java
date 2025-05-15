//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n < 2) {
            return n;
        }
        int res = 0;
        int l = 0;
        Set<Character> chars = new HashSet<>();
        for (int r = 0; r < n; r++) {
            char curr = s.charAt(r);
            while (chars.contains(curr)) {
                chars.remove(s.charAt(l));
                l++;
            }
            chars.add(curr);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
