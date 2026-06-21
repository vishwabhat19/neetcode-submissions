class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lowSpeed = 0;
        int highSpeed = 0;
        for(int pile : piles) {
            if (pile > highSpeed) {
                highSpeed = pile;
            }
        }
        int mid = lowSpeed + (highSpeed - lowSpeed)/ 2;
        while (lowSpeed <= highSpeed) {
            long timeTaken = 0;
            for(int pile : piles) {
                timeTaken = timeTaken + (int) Math.ceil((double)pile/mid);
            }

            if (timeTaken > h) {
                lowSpeed = mid + 1;
            }

            else {
                highSpeed = mid - 1;
            }

            mid = lowSpeed + (highSpeed - lowSpeed)/ 2;
        }

        return mid;
    }
}
