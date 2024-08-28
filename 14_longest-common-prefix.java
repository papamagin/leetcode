https://leetcode.com/problems/longest-common-prefix/description/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        for (String s : strs) {
            if (s.length() == 0) {
                return "";
            }
        }

        StringBuilder res = new StringBuilder();
        int pos = 0;

        while (true) {
            if (strs[0].length() == pos) {
                return res.toString();
            }
            char candidate = strs[0].charAt(pos);
            for (String s : strs) {
                if (pos == s.length() || s.charAt(pos) != candidate) {
                    return res.toString();
                }
            }

            res.append(candidate);
            pos++;
        }
    }
}
