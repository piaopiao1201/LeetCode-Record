public class Main {
    public static void main(String[] args) {
        int[] nums={4,2,1};
        checkPossibility(nums);
    }
    public static boolean checkPossibility(int[] nums) {
        if(nums.length<=2){
            return true;
        }
        int count=0;
        if(nums[0]>nums[1]){
            nums[0]=nums[1];
            count++;
        }
        for(int i=1;i<nums.length-1;i++){
            int left=nums[i-1];
            int right=nums[i+1];
            if(nums[i]>right){
                if(count>0){
                    return false;
                }
                count++;
                if(left>right){
                    nums[i+1]=nums[i];
                }else{
                    nums[i]=left;
                }
            }
        }
        return true;
    }
}
