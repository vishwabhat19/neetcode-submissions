class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        for(int g : gas) {
            sumGas+=g;
        }

        int sumCost = 0;
        for(int c : cost) {
            sumCost +=c;
        }

        if (sumGas < sumCost) return -1;

        int total = 0;

        int startIdx = 0;

        for(int i=0;i<gas.length;i++) {
            total = total + (gas[i] - cost[i]);

            if (total < 0) {
                total = 0;
                startIdx = i + 1;
            }
        }

        return startIdx;
    }
}
