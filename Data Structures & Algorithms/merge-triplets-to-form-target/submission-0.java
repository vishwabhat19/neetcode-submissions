class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean foundA = false;
        boolean foundB = false;
        boolean foundC = false;
        for(int[] t : triplets) {
            if (t[0] > target[0] || t[1]> target[1] || t[2] > target[2]) continue;
            if (t[0] == target[0]) foundA = true;
            if (t[1] == target[1]) foundB = true;
            if (t[2] == target[2]) foundC = true;
            if (foundA && foundB && foundC) return true;
        }
        return (foundA && foundB && foundC);
    }
}
