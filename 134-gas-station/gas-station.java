class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //First we check its possible to complete circular tour
        int n = gas.length;
        int total_gas = 0, total_cost = 0;
        for(int i=0; i<n; i++) {
            total_gas += gas[i];
            total_cost += cost[i];
        }
        if(total_gas < total_cost)
            return -1;

        //means circular tour is possible
        //we will try to start from every index, if any time current fuel < 0
        //means we can not start from that index
        int current_fuel = 0, start = 0;
        for(int i=0; i<n; i++) {
            current_fuel += gas[i] - cost[i];
            if(current_fuel < 0 ) {
                start = i+1;
                current_fuel = 0;
            }
        }

        return start;
    }
}