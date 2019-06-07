public class main {
    public static void main(String[] args) {
        long a=1233;
        int b=122;
        int c=(int)a/b;
        System.out.println(a/b);
    }
    public static int[] productExceptSelf(int[] nums) {
        long num=1;
        int zeroNum=0;
        for(int i:nums){
            if(i==0){
                zeroNum++;
                if(zeroNum>1){
                    num=0;
                    break;
                }else{
                    continue;
                }
            }
            num*=i;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                nums[i]=(int)num;
                continue;
            }
            if(zeroNum>0){
                nums[i]=0;
                continue;
            }
            nums[i]=(int)num/nums[i];
        }
        return nums;
    }
}
