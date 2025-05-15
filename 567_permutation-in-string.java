//https://leetcode.com/problems/permutation-in-string/description/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 > n2) {
            return false;
        }
        int[] s1Letters = new int[26];
        for (char c : s1.toCharArray()) {
            s1Letters[c - 'a']++;
        }
        int[] curr = new int[26];
        for (int i = 0; i < n1; i++) {
            curr[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(s1Letters, curr)) {
            return true;
        }
        int l = 0;
        for (int r = n1; r < n2; r++) {
            curr[s2.charAt(r) - 'a']++;
            curr[s2.charAt(l) - 'a']--;
            l++;
            if (Arrays.equals(s1Letters, curr)) {
                return true;
            }
        }

        return false;
    }
}
