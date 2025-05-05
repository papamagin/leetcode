//https://leetcode.com/problems/maximum-number-of-balloons/description/

class Solution {
    public int maxNumberOfBalloons(String text) {
        if (text.length() < 7) {
            return 0;
        }
        int B = 0;
        int A = 1;
        int L = 2;
        int O = 3;
        int N = 4;
        int[] balloon = new int[5];

        for (char c : text.toCharArray()) {
            if (c == 'b') {
                balloon[B] = balloon[B]+1;
            }
            if (c == 'a') {
                balloon[A] = balloon[A]+1;
            }
            if (c == 'l') {
                balloon[L] = balloon[L]+1;
            }
            if (c == 'o') {
                balloon[O] = balloon[O]+1;
            }
            if (c == 'n') {
                balloon[N] = balloon[N]+1;
            }
        }

        balloon[L] = balloon[L]/2;
        balloon[O] = balloon[O]/2;

        int res = balloon[B];
        for (int i : balloon) {
            if (i < res) {
                res = i;
            }
        }

        return res;
    }
}
