//https://leetcode.com/problems/generate-parentheses/description/

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n, new StringBuilder());
        return res;
    }
    private void backtrack(int opened, int closed, int n, StringBuilder sb) {
        if (sb.length() == n*2) {
            res.add(sb.toString());
            return;
        }
        int openedLeft = n - opened;
        int closedLeft = n - closed;
        if (openedLeft > 0) {
            sb.append('(');
            backtrack(opened + 1, closed, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (closedLeft > 0 && opened > closed) {
            sb.append(')');
            backtrack(opened, closed + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
