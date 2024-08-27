// https://leetcode.com/problems/merge-strings-alternately/description/
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        if (l1 == 0) {
            return word2;
        }
        if (l2 == 0) {
            return word1;
        }
        StringBuilder res = new StringBuilder();
        int len = Math.max(l1, l2);
        for (int i = 0; i < len; i++) {
            if (i > l1 - 1) {
                res.append(word2.charAt(i));
            } else if (i > l2 - 1) {
                res.append(word1.charAt(i));
            } else {
                res.append(word1.charAt(i));
                res.append(word2.charAt(i));
            }
        }
        return res.toString();
    }
}
