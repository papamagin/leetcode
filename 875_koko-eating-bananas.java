//https://leetcode.com/problems/koko-eating-bananas/description/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int maxSpeed = 0;
        for (int i : piles) {
            maxSpeed = Math.max(i, maxSpeed);
        }

        if (n == h) {
            return maxSpeed;
        }

        int l = 1;
        int r = maxSpeed;

        while (l <= r) {
            int mid = (l + r)/2;
            if (!isFit(mid, h, piles)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }

    boolean isFit(int speed, int time, int[] piles) {
        long sum = 0;
        for (int i : piles) {
            // sum += (int) Math.ceil((double) i / speed);
            sum += i % speed == 0 ? i/speed : i/speed + 1; 
        }
        return sum <= time;
    }
}
