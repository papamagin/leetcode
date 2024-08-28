// https://leetcode.com/problems/is-subsequence/description/

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int t_pos = 0;
        int found = 0;
        for (int i = 0; i < s.length(); i++) {
            if (t_pos == t.length()) {
                break;
            }

            for (int j = t_pos; j < t.length(); j++) {
                t_pos++;
                if (s.charAt(i) == t.charAt(j)) {
                    found++;
                    break;
                }
            }   
        }

        if (found == s.length()) {
            return true;
        }

        return false;
    }
}
