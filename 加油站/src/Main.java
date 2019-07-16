public class Main {
    public static void main(String[] args) {

    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_gas=0;
        int current_gas=0;
        int start_index=0;
        for(int i=0;i<gas.length){
            total_gas+=gas[i]-cost[i];
            current_gas+=gas[i]-cost[i];
            if(current_gas<0){
                start_index=i;
                current_gas=0;
            }
        }
        return total_gas<0?start_index:-1;
    }
}
