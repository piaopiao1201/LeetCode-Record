public class Main {
    public static void main(String[] args) {
        System.out.println(1);
    }
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int begin=0;
        int end=0;
        int sum=nums[begin];
        int time=0;
        while(true){
            if(sum<k){
                time+=end-begin+1;
                if(end>=nums.length-1){
                    break;
                }
                end++;
                sum*=nums[end];
            }else{
                sum/=nums[begin];
                if(begin>=nums.length-1){
                    break;
                }
                begin++;
            }
        }
        return time;
    }
}
