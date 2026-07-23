class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for(int g : gas) {
            totalGas+=g;
        }
        for(int c : cost) {
            totalCost+=c;
        }

        if (totalGas < totalCost) return -1;

        int result = 0;

        int currentCost = 0;

        for(int i=0;i<gas.length;i++) {
            currentCost = currentCost + (gas[i] - cost[i]);
            if (currentCost < 0) {
                currentCost = 0;//reset
                result = i+1;
            }
        }

        return result;


    }
}
