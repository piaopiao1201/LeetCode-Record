public class Main {
    public static void main(String[] args) {
        int[] nums={7,6,5,4,3,2,1};
        int res=thirdMax(nums);
        System.out.println(1);
    }
    public static int thirdMax(int[] nums) {
        int first=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;
        int third=Integer.MIN_VALUE;
        boolean flag1=false;
        boolean flag2=false;
        boolean flag3=false;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>first){
                sum++;
                third=second;
                second=first;
                first=nums[i];
            }else if(nums[i]==first){
                if(nums[i]==Integer.MIN_VALUE&&!flag1){
                    flag1=true;
                    sum++;
                }
                continue;
            }else if(nums[i]>second){
                sum++;
                third=second;
                second=nums[i];
            }else if(nums[i]==second){
                if(nums[i]==Integer.MIN_VALUE&&!flag2){
                    flag2=true;
                    sum++;
                }
                continue;
            }else if(nums[i]>=third){
                sum++;
                third=nums[i];
            }
        }
        return sum>=3?third:first;
        // if(third==Integer.MIN_VALUE&&!flag){
        //     return first;
        // }else{
        //     return third;
        // }
    }
}
