public class Main {
    public static void main(String[] args) {
        int[] nums={1,2,1,2,1};
        int k=3;
        subarraySum(nums,k);
    }
    public static int subarraySum(int[] nums, int k) {
        int[] sum=new int[nums.length];
        int sumRes=0;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                sum[i]=nums[i];
            }else{
                sum[i]=nums[i]+sum[i-1];
            }
            if(sum[i]==k){
                sumRes++;
            }
        }
        for(int i=1;i<nums.length;i++){
            int tempSum=sum[i];
            for(int j=0;j<i;j++){
                tempSum-=nums[i];
                if(tempSum==k){
                    sumRes++;
                }
            }
        }
        return sumRes;
    }
}
